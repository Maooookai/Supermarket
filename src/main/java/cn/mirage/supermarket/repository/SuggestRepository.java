package cn.mirage.supermarket.repository;

import cn.mirage.supermarket.entity.Suggest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestRepository extends JpaRepository<Suggest,Long> {
}
