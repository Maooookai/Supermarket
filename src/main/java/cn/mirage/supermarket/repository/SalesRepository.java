package cn.mirage.supermarket.repository;

import cn.mirage.supermarket.entity.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findAllByTimeContains(String time);
    Sales findFirstByTimeContainsOrderByQuantityDesc(String time);
    Page<Sales> findAllByNameIsNotNullOrderByQuantityDesc(Pageable pageable);
    Sales findFirstByCode(Long code);
}
