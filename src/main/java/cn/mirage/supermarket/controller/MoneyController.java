package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.service.SalesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class MoneyController {

    SalesService salesService;

    public MoneyController(SalesService salesService) {
        this.salesService = salesService;
    }

    @RequestMapping(value = "money")
    public ModelAndView money(ModelAndView modelAndView) {
        modelAndView.setViewName("money");
        return modelAndView;
    }

    @RequestMapping(value = "today")
    public ModelAndView today(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("today");
        session.setAttribute("todayInfo", salesService.today());
        return modelAndView;
    }

    @RequestMapping(value = "curMonth")
    public ModelAndView curMonth(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("curMonth");
        session.setAttribute("curMonthInfo", salesService.currentMonth());
        return modelAndView;
    }

    @RequestMapping(value = "days")
    public ModelAndView days(ModelAndView modelAndView, HttpSession session) {
        session.setAttribute("daysInfo",salesService.days());
        modelAndView.setViewName("days");
        return modelAndView;
    }

    @RequestMapping(value = "rank")
    public ModelAndView list(ModelAndView modelAndView, @RequestParam(defaultValue = "0") int pageNum, HttpSession session){
        modelAndView.setViewName("rank");
        session.setAttribute("ranks",salesService.list(pageNum));
        return modelAndView;
    }

    @RequestMapping(value = "newRank")
    public ModelAndView newCommodity(ModelAndView modelAndView,HttpSession session){
        session.setAttribute("newRanks",salesService.newCommodity());
        modelAndView.setViewName("newCommodity");
        return modelAndView;
    }

}
