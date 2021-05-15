package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.Commodity;
import cn.mirage.supermarket.entity.CustomerReturn;
import cn.mirage.supermarket.entity.Sales;
import cn.mirage.supermarket.repository.CommodityRepository;
import cn.mirage.supermarket.repository.CustomerReturnRepository;
import cn.mirage.supermarket.repository.SalesRepository;
import cn.mirage.supermarket.service.SalesService;
import cn.mirage.supermarket.to.*;
import cn.mirage.supermarket.tool.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    CustomerReturnRepository customerReturnRepository;
    SalesRepository salesRepository;
    CommodityRepository commodityRepository;

    public SalesServiceImpl(CustomerReturnRepository customerReturnRepository, SalesRepository salesRepository, CommodityRepository commodityRepository) {
        this.customerReturnRepository = customerReturnRepository;
        this.salesRepository = salesRepository;
        this.commodityRepository = commodityRepository;
    }

    @Override
    public void customerReturn(ReturnDTO dto) {
        Commodity commodity = new Commodity();
        if (commodityRepository.findByCode(Long.valueOf(dto.getCode())).isPresent())
            commodity = commodityRepository.findByCode(Long.valueOf(dto.getCode())).get();
        CustomerReturn customerReturn = new CustomerReturn();
        customerReturn.setReturnTime(Time.currentTime());
        customerReturn.setCode(Long.valueOf(dto.getCode()));
        customerReturn.setQuantity(Integer.valueOf(dto.getQuantity()));
        customerReturnRepository.save(customerReturn);
        commodity.setStock(commodity.getStock() + Integer.parseInt(dto.getQuantity()));
        commodityRepository.save(commodity);
    }

    @Override
    public void sell(SellDTO dto) {
        Commodity commodity = new Commodity();
        if (commodityRepository.findByCode(Long.valueOf(dto.getCode())).isPresent())
            commodity = commodityRepository.findByCode(Long.valueOf(dto.getCode())).get();
        Sales sales = new Sales();
        sales.setCode(Long.valueOf(dto.getCode()));
        sales.setQuantity(Integer.valueOf(dto.getQuantity()));
        sales.setName(commodity.getName());
        sales.setPrice(commodity.getPrice());
        sales.setTime(Time.currentTime());
        salesRepository.save(sales);
    }

    @Override
    public TodayDTO today() {
        TodayDTO todayDTO = new TodayDTO();
        float todayMoney = (float) 0;
        float todayProfit = (float) 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Sales> today = salesRepository.findAllByTimeContains(simpleDateFormat.format(new Date()));
        for (Sales sales : today) {
            if (commodityRepository.findByCode(sales.getCode()).isPresent())
                todayProfit = todayProfit + sales.getPrice() - commodityRepository.findByCode(sales.getCode()).get().getPurchasePrice();
            todayMoney = todayMoney + sales.getPrice();
        }
        if (!salesRepository.findAllByTimeContains(simpleDateFormat.format(new Date())).isEmpty())
            todayDTO.setMostCommodityName(salesRepository.findFirstByTimeContainsOrderByQuantityDesc(simpleDateFormat.format(new Date())).getName());
        else todayDTO.setMostCommodityName("今日暂无销售");
        if (!salesRepository.findAllByTimeContains(simpleDateFormat.format(new Date())).isEmpty())
            todayDTO.setMostCommodityNumber(String.valueOf(salesRepository.findFirstByTimeContainsOrderByQuantityDesc(simpleDateFormat.format(new Date())).getQuantity()));
        else todayDTO.setMostCommodityNumber("0");
        todayDTO.setSales(String.valueOf(todayMoney));
        todayDTO.setProfit(String.valueOf(todayProfit));
        return todayDTO;
    }

    @Override
    public CurrentMonthDTO currentMonth() {
        CurrentMonthDTO currentMonthDTO = new CurrentMonthDTO();
        float monthMoney = (float) 0;
        float monthProfit = (float) 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        List<Sales> month = salesRepository.findAllByTimeContains(simpleDateFormat.format(new Date()));
        for (Sales sales : month) {
            if (commodityRepository.findByCode(sales.getCode()).isPresent())
                monthProfit = monthProfit + sales.getPrice() - commodityRepository.findByCode(sales.getCode()).get().getPurchasePrice();
            monthMoney = monthMoney + sales.getPrice();
        }
        currentMonthDTO.setSales(String.valueOf(monthMoney));
        currentMonthDTO.setProfit(String.valueOf(monthProfit));
        currentMonthDTO.setMostCommodityName(salesRepository.findFirstByTimeContainsOrderByQuantityDesc(simpleDateFormat.format(new Date())).getName());
        currentMonthDTO.setMostCommodityNumber(String.valueOf(salesRepository.findFirstByTimeContainsOrderByQuantityDesc(simpleDateFormat.format(new Date())).getQuantity()));
        return currentMonthDTO;
    }

    @Override
    public DaysDTO days() {
        DaysDTO dto = new DaysDTO();
        float dayMoney;
        List<Float> money = new ArrayList<>();
        List<Sales> sales;
        List<String> dates = days30();
        for (String date : dates) {
            sales = salesRepository.findAllByTimeContains(date);
            dayMoney = 0;
            for (Sales sale : sales)
                dayMoney = dayMoney + sale.getPrice();
            money.add(dayMoney);
        }
        dto.setDays(dates);
        dto.setSales(money);
        return dto;
    }

    @Override
    public List<Sales> newCommodity() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        List<Commodity> commodities = commodityRepository.findAllByFirstPurchaseTimeContains(simpleDateFormat.format(new Date()));
        List<Sales> sales = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (!(salesRepository.findFirstByCode(commodity.getCode()) == null))
                sales.add(salesRepository.findFirstByCode(commodity.getCode()));
        }
        return sales;
    }

    @Override
    public Page<Sales> list(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        return salesRepository.findAllByNameIsNotNullOrderByQuantityDesc(pageable);
    }

    public static List<String> days30() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String maxDateStr = fmt.format(today);
        String minDateStr;

        Calendar calc = Calendar.getInstance();
        List<String> dates = new ArrayList<>();

        try {
            for (int i = 0; i < 30; i++) {
                calc.setTime(fmt.parse(maxDateStr));
                calc.add(Calendar.DATE, -i);
                Date minDate = calc.getTime();
                minDateStr = fmt.format(minDate);
                dates.add(minDateStr);

            }
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return dates;
    }

}
