package cn.mirage.supermarket.service;

import cn.mirage.supermarket.entity.Sales;
import cn.mirage.supermarket.to.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SalesService {

    void customerReturn(ReturnDTO dto);

    void sell(SellDTO dto);

    TodayDTO today();

    CurrentMonthDTO currentMonth();

    DaysDTO days();

    List<Sales> newCommodity();

    Page<Sales> list(int page);

}
