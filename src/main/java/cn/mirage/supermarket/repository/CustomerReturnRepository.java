package cn.mirage.supermarket.repository;

import cn.mirage.supermarket.entity.CustomerReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReturnRepository extends JpaRepository<CustomerReturn, Long> {
}
