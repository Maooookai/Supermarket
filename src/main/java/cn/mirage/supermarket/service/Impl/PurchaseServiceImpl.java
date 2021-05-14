package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.Commodity;
import cn.mirage.supermarket.entity.Purchase;
import cn.mirage.supermarket.repository.CommodityRepository;
import cn.mirage.supermarket.repository.PurchaseRepository;
import cn.mirage.supermarket.service.PurchaseService;
import cn.mirage.supermarket.to.BuyDTO;
import cn.mirage.supermarket.to.ReturnDTO;
import cn.mirage.supermarket.tool.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    PurchaseRepository purchaseRepository;
    CommodityRepository commodityRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, CommodityRepository commodityRepository) {
        this.purchaseRepository = purchaseRepository;
        this.commodityRepository = commodityRepository;
    }

    @Override
    public void buy(BuyDTO dto) {
        Purchase purchase = new Purchase();
        purchase.setCode(Long.valueOf(dto.getCode()));
        purchase.setName(dto.getName());
        purchase.setPerson(Long.valueOf(dto.getPerson()));
        purchase.setQuantity(Integer.valueOf(dto.getQuantity()));
        purchase.setTime(Time.currentTime());
        purchase.setPrice(Float.valueOf(dto.getPrice()));
        purchaseRepository.save(purchase);
        if (commodityRepository.findByCode(Long.valueOf(dto.getCode())).isPresent()) {
            Commodity commodity = commodityRepository.findByCode(Long.valueOf(dto.getCode())).get();
            commodity.setStock(commodity.getStock() + Integer.parseInt(dto.getQuantity()));
        } else {
            Commodity commodity = new Commodity();
            commodity.setCode(Long.valueOf(dto.getCode()));
            commodity.setName(dto.getName());
            commodity.setPurchasePrice(Float.valueOf(dto.getPrice()));
            commodity.setPrice(Float.valueOf(dto.getPrice()));
            commodity.setStock(Integer.valueOf(dto.getQuantity()));
            commodity.setFirstPurchaseTime(Time.currentTime());
            commodityRepository.save(commodity);
        }
    }

    @Override
    public void return1(ReturnDTO dto) {
        Commodity commodity = new Commodity();
        if (commodityRepository.findByCode(Long.valueOf(dto.getCode())).isPresent())
            commodity = commodityRepository.findByCode(Long.valueOf(dto.getCode())).get();
        commodity.setStock(commodity.getStock() - Integer.parseInt(dto.getQuantity()));
        commodityRepository.save(commodity);
    }
}
