package cn.mirage.supermarket.service;

import cn.mirage.supermarket.entity.Staff;
import cn.mirage.supermarket.to.StaffAddDTO;
import cn.mirage.supermarket.to.StaffEditDTO;
import org.springframework.data.domain.Page;

public interface StaffService {

    Page<Staff> list(int page);

    Staff getOne(Long id);

    void edit(StaffEditDTO dto);

    void add(StaffAddDTO dto);

    void delete(String id);

}
