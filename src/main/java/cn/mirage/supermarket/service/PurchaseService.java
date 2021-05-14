package cn.mirage.supermarket.service;

import cn.mirage.supermarket.to.BuyDTO;
import cn.mirage.supermarket.to.ReturnDTO;

public interface PurchaseService {

    void buy(BuyDTO dto);

    void return1(ReturnDTO dto);

}
