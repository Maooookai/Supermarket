package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.Commodity;
import cn.mirage.supermarket.entity.CustomerReturn;
import cn.mirage.supermarket.entity.Sales;
import cn.mirage.supermarket.repository.CommodityRepository;
import cn.mirage.supermarket.repository.CustomerReturnRepository;
import cn.mirage.supermarket.repository.SalesRepository;
import cn.mirage.supermarket.service.SalesService;
import cn.mirage.supermarket.to.ReturnDTO;
import cn.mirage.supermarket.to.SellDTO;
import cn.mirage.supermarket.tool.Time;
import org.springframework.stereotype.Service;

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


}
