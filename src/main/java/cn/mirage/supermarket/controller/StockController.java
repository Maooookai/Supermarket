package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.service.StockService;
import cn.mirage.supermarket.to.CommodityEditDTO;
import cn.mirage.supermarket.to.CommoditySearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class StockController {

    StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "stock")
    public ModelAndView stock(ModelAndView modelAndView) {
        modelAndView.setViewName("stock");
        return modelAndView;
    }

    @RequestMapping(value = "allGoods", method = RequestMethod.GET)
    public ModelAndView allGoods(ModelAndView modelAndView, @RequestParam(defaultValue = "0") int pageNum, HttpSession session) {
        modelAndView.setViewName("allGoods");
        session.setAttribute("goods", stockService.list(pageNum));
        return modelAndView;
    }

    @RequestMapping(value = "/editGoods", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, String editId) {
        modelAndView.setViewName("editGoods");
        session.setAttribute("editInfo", stockService.getOne(Long.valueOf(editId)));
        return modelAndView;
    }

    @RequestMapping(value = "/editGoods", method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, CommodityEditDTO dto) {
        stockService.edit(dto);
        modelAndView.setViewName("allGoods");
        session.setAttribute("goods", stockService.list(0));
        return modelAndView;
    }

    @RequestMapping(value = "/searchGoods", method = RequestMethod.GET)
    public ModelAndView search(ModelAndView modelAndView) {
        modelAndView.setViewName("searchGoods");
        return modelAndView;
    }

    @RequestMapping(value = "/searchGoods", method = RequestMethod.POST)
    public ModelAndView search(ModelAndView modelAndView, HttpSession session, CommoditySearchDTO dto) {
        session.removeAttribute("search");
        session.setAttribute("searchResult", stockService.search(dto));
        modelAndView.setViewName("searchResult");
        return modelAndView;
    }

}
