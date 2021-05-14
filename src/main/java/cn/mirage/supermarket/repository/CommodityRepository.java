package cn.mirage.supermarket.repository;

import cn.mirage.supermarket.entity.Commodity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity,Long> {


    @NotNull List<Commodity> findAll();

    Optional<Commodity> findByCode(Long code);

    List<Commodity> findAllByNameContains(String name);

    List<Commodity> findAllByCodeContains(Long code);

}
