package cn.mirage.supermarket.service;

import cn.mirage.supermarket.entity.Supplier;
import cn.mirage.supermarket.to.SupplierAddDTO;
import cn.mirage.supermarket.to.SupplierEditDTO;
import org.springframework.data.domain.Page;

public interface SupplierService {
    Page<Supplier> list(int page);

    Supplier getOne(Long id);

    void edit(SupplierEditDTO dto);

    void add(SupplierAddDTO dto);

    void delete(String id);
}
