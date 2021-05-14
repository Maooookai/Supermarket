package cn.mirage.supermarket.repository;

import cn.mirage.supermarket.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {

    Optional<Announcement> findFirstByContentIsNotNullOrderByTimeDesc();

}
