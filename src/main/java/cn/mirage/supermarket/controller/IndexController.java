package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    AnnouncementService announcementService;

    @Autowired
    public IndexController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpSession session) {
        session.setAttribute("announcement", announcementService.latest());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index2(ModelAndView modelAndView, HttpSession session) {
        session.setAttribute("announcement", announcementService.latest());
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
