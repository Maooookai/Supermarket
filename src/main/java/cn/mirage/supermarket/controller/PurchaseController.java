package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.service.PurchaseService;
import cn.mirage.supermarket.to.BuyDTO;
import cn.mirage.supermarket.to.ReturnDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PurchaseController {

    PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(value = "purchase")
    public ModelAndView purchase(ModelAndView modelAndView) {
        modelAndView.setViewName("purchase");
        return modelAndView;
    }

    @RequestMapping(value = "buy", method = RequestMethod.POST)
    public ModelAndView buy(ModelAndView modelAndView, BuyDTO dto) {
        purchaseService.buy(dto);
        modelAndView.setViewName("buy");
        modelAndView.addObject("buyResult", "进货成功");
        return modelAndView;
    }

    @RequestMapping(value = "buy", method = RequestMethod.GET)
    public ModelAndView buy(ModelAndView modelAndView) {
        modelAndView.setViewName("buy");
        return modelAndView;
    }

    @RequestMapping(value = "return", method = RequestMethod.POST)
    public ModelAndView return1(ModelAndView modelAndView, ReturnDTO dto) {
        purchaseService.return1(dto);
        modelAndView.setViewName("return");
        modelAndView.addObject("returnResult", "退货成功");
        return modelAndView;
    }

    @RequestMapping(value = "return", method = RequestMethod.GET)
    public ModelAndView return1(ModelAndView modelAndView) {
        modelAndView.setViewName("return");
        return modelAndView;
    }

}
