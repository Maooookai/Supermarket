package cn.mirage.supermarket.service;

import cn.mirage.supermarket.entity.Announcement;
import cn.mirage.supermarket.to.AnnouncementVO;
import org.springframework.data.domain.Page;

public interface AnnouncementService {

    AnnouncementVO latest();

    Announcement getOne(Long id);

    void edit(Long id, String content);

    void add(Long id, String content);

    void delete(Long id);

    Page<Announcement> boards(int page);

}
