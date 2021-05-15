package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.Announcement;
import cn.mirage.supermarket.repository.AnnouncementRepository;
import cn.mirage.supermarket.service.AnnouncementService;
import cn.mirage.supermarket.to.AnnouncementVO;
import cn.mirage.supermarket.tool.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }


    @Override
    public AnnouncementVO latest() {
        AnnouncementVO announcementVO = new AnnouncementVO();
        if (announcementRepository.findFirstByContentIsNotNullOrderByTimeDesc().isPresent()) {
            announcementVO.setContent(announcementRepository.findFirstByContentIsNotNullOrderByTimeDesc().get().getContent());
            announcementVO.setTime(announcementRepository.findFirstByContentIsNotNullOrderByTimeDesc().get().getTime());
        } else {
            announcementVO.setContent("暂无公告");
            announcementVO.setTime("");
        }
        return announcementVO;
    }

    @Override
    public Announcement getOne(Long id) {
        return announcementRepository.getOne(id);
    }

    @Override
    public void edit(Long id, String content) {
        Announcement announcement = announcementRepository.getOne(id);
        announcement.setContent(content);
        announcementRepository.save(announcement);
    }

    @Override
    public void add(Long id, String content) {
        Announcement announcement = new Announcement();
        announcement.setTime(Time.currentTime());
        announcement.setCreatorId(id);
        announcement.setContent(content);
        announcementRepository.save(announcement);
    }

    @Override
    public void delete(Long id) {
        announcementRepository.delete(announcementRepository.getOne(id));
    }

    @Override
    public Page<Announcement> boards(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("time").descending());
        return announcementRepository.findAll(pageable);
    }
}
