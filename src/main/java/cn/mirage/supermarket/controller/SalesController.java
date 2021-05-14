package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.service.SalesService;
import cn.mirage.supermarket.to.ReturnDTO;
import cn.mirage.supermarket.to.SellDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SalesController {

    SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService){
        this.salesService = salesService;
    }

    @RequestMapping(value = "sales")
    public ModelAndView sales(ModelAndView modelAndView){
        modelAndView.setViewName("sales");
        return modelAndView;
    }

    @RequestMapping(value = "customerReturn")
    public ModelAndView customerReturn(ModelAndView modelAndView){
        modelAndView.setViewName("customerReturn");
        return modelAndView;
    }

    @RequestMapping(value = "customerReturn",method = RequestMethod.POST)
    public ModelAndView customerReturn(ModelAndView modelAndView, ReturnDTO dto){
        salesService.customerReturn(dto);
        modelAndView.addObject("returnResult","退货成功");
        modelAndView.setViewName("customerReturn");
        return modelAndView;
    }

    @RequestMapping(value = "sell")
    public ModelAndView sell(ModelAndView modelAndView){
        modelAndView.setViewName("sell");
        return modelAndView;
    }

    @RequestMapping(value = "sell",method = RequestMethod.POST)
    public ModelAndView customerReturn(ModelAndView modelAndView, SellDTO dto){
        salesService.sell(dto);
        modelAndView.addObject("sellResult","售出成功");
        modelAndView.setViewName("sell");
        return modelAndView;
    }

}
