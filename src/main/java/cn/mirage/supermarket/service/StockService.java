package cn.mirage.supermarket.service;

import cn.mirage.supermarket.entity.Commodity;
import cn.mirage.supermarket.to.CommodityEditDTO;
import cn.mirage.supermarket.to.CommoditySearchDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StockService {
    Page<Commodity> list(int page);
    void edit(CommodityEditDTO dto);
    Commodity getOne(Long id);
    List<Commodity> search(CommoditySearchDTO dto);
}
