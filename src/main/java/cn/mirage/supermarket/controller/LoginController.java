package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.service.AnnouncementService;
import cn.mirage.supermarket.service.LoginService;
import cn.mirage.supermarket.service.UserService;
import cn.mirage.supermarket.to.LoginDTO;
import cn.mirage.supermarket.to.LoginVO;
import cn.mirage.supermarket.tool.HttpGetUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {

    LoginService loginService;
    UserService userService;
    AnnouncementService announcementServiceService;

    @Autowired
    public LoginController(LoginService loginService, UserService userService, AnnouncementService announcementService) {
        this.loginService = loginService;
        this.userService = userService;
        this.announcementServiceService = announcementService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView modelAndView, LoginDTO loginDTO, HttpSession session) {

        LoginVO loginVO = loginService.login(loginDTO);
        session.setAttribute("board", announcementServiceService.latest());
        session.setAttribute("user", loginVO);



        if (!loginVO.isSuccess()) {
            modelAndView.addObject("error", loginVO.getMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }

        session.setAttribute("userinfo", userService.getUserById(Long.parseLong(loginDTO.getId())));
        modelAndView.setViewName("home");

        return modelAndView;
    }

    public ModelAndView exit(ModelAndView modelAndView,HttpSession session){
        session.removeAttribute("user");
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
