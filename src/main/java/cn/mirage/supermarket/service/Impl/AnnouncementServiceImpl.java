package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.repository.AnnouncementRepository;
import cn.mirage.supermarket.service.AnnouncementService;
import cn.mirage.supermarket.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository){
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
}
