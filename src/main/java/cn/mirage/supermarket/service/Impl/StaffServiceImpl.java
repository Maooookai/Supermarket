package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.Staff;
import cn.mirage.supermarket.repository.StaffRepository;
import cn.mirage.supermarket.service.StaffService;
import cn.mirage.supermarket.to.StaffAddDTO;
import cn.mirage.supermarket.to.StaffEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Page<Staff> list(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        return staffRepository.findAll(pageable);
    }

    @Override
    public void edit(StaffEditDTO dto) {
        Staff staff = new Staff();
        if (staffRepository.findById(Long.valueOf(dto.getId())).isPresent())
            staff = staffRepository.findById(Long.valueOf(dto.getId())).get();
        staff.setAge(dto.getAge());
        staff.setGender(dto.getGender());
        staff.setName(dto.getName());
        staff.setPhone(dto.getPhone());
        staff.setSalary(dto.getSalary());
        staffRepository.save(staff);
    }

    @Override
    public void add(StaffAddDTO dto) {
        Staff staff = new Staff();
        staff.setAge(dto.getAge());
        staff.setGender(dto.getGender());
        staff.setName(dto.getName());
        staff.setPhone(dto.getPhone());
        staff.setSalary(dto.getSalary());
        staffRepository.save(staff);
    }

    @Override
    public void delete(String id) {
        Staff staff = new Staff();
        if (staffRepository.findById(Long.valueOf(id)).isPresent())
            staff = staffRepository.findById(Long.valueOf(id)).get();
        staffRepository.delete(staff);
    }

    @Override
    public Staff getOne(Long id) {
        Staff staff = new Staff();
        if (staffRepository.findById(id).isPresent())
            staff = staffRepository.findById(id).get();
        return staff;
    }

}
