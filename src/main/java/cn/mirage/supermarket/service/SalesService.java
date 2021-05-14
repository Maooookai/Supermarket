package cn.mirage.supermarket.service;

import cn.mirage.supermarket.to.ReturnDTO;
import cn.mirage.supermarket.to.SellDTO;

public interface SalesService {

    void customerReturn(ReturnDTO dto);

    void sell(SellDTO dto);

}
