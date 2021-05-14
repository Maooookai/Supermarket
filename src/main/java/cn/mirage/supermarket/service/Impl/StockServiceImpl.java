package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.Commodity;
import cn.mirage.supermarket.repository.CommodityRepository;
import cn.mirage.supermarket.service.StockService;
import cn.mirage.supermarket.to.CommodityEditDTO;
import cn.mirage.supermarket.to.CommoditySearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    CommodityRepository commodityRepository;

    @Autowired
    public StockServiceImpl(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public Page<Commodity> list(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        return commodityRepository.findAll(pageable);
    }

    @Override
    public void edit(CommodityEditDTO dto) {
        Commodity commodity = new Commodity();
        if (commodityRepository.findById(Long.valueOf(dto.getId())).isPresent())
            commodity = commodityRepository.findById(Long.valueOf(dto.getId())).get();
        commodity.setStock(Integer.valueOf(dto.getStock()));
        commodity.setPrice(Float.valueOf(dto.getPrice()));
        commodity.setCode(Long.valueOf(dto.getCode()));
        commodity.setName(dto.getName());
        commodity.setPurchasePrice(Float.valueOf(dto.getPurchasePrice()));
        commodityRepository.save(commodity);
    }

    @Override
    public Commodity getOne(Long id) {
        Commodity commodity = new Commodity();
        if (commodityRepository.findById(id).isPresent())
            commodity = commodityRepository.findById(id).get();
        return commodity;
    }

    @Override
    public List<Commodity> search(CommoditySearchDTO dto) {
        switch (dto.getBy()) {
            case "name": {
                if (!commodityRepository.findAllByNameContains(dto.getContent()).isEmpty())
                    return commodityRepository.findAllByNameContains(dto.getContent());
                 else return new ArrayList<>();
            }
            case "code": {
                if (!commodityRepository.findAllByNameContains(dto.getContent()).isEmpty())
                    return commodityRepository.findAllByCodeContains(Long.valueOf(dto.getContent()));
                else return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
