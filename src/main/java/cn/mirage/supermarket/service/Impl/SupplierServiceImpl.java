package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.Supplier;
import cn.mirage.supermarket.repository.SupplierRepository;
import cn.mirage.supermarket.service.SupplierService;
import cn.mirage.supermarket.to.SupplierAddDTO;
import cn.mirage.supermarket.to.SupplierEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Page<Supplier> list(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        return supplierRepository.findAll(pageable);
    }

    @Override
    public Supplier getOne(Long id) {
        return supplierRepository.getOne(id);
    }

    @Override
    public void edit(SupplierEditDTO dto) {
        Supplier supplier = supplierRepository.getOne(Long.valueOf(dto.getId()));
        supplier.setName(dto.getName());
        supplier.setId(Long.valueOf(dto.getId()));
        supplierRepository.save(supplier);
    }

    @Override
    public void add(SupplierAddDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setId(Long.valueOf(dto.getId()));
        supplier.setName(dto.getName());
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(String id) {
        supplierRepository.delete(supplierRepository.getOne(Long.valueOf(id)));
    }
}
