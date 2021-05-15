package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.entity.User;
import cn.mirage.supermarket.service.AnnouncementService;
import cn.mirage.supermarket.service.UserService;
import cn.mirage.supermarket.to.BoardEditVO;
import cn.mirage.supermarket.to.PasswordDTO;
import cn.mirage.supermarket.to.PasswordVO;
import cn.mirage.supermarket.tool.HttpGetUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    AnnouncementService announcementService;
    UserService userService;

    @Autowired
    public IndexController(AnnouncementService announcementService,UserService userService) {
        this.announcementService = announcementService;
        this.userService = userService;
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

    @RequestMapping(value = "access")
    public ModelAndView access(ModelAndView modelAndView,HttpSession session){
        modelAndView.setViewName("access");
        System.out.println(HttpGetUtil.getHttpPlainText("http://timor.tech/api/holiday/tts/next"));
        JSONObject getDailySentence = JSONObject.fromObject(HttpGetUtil.getHttpPlainText("https://timor.tech/api/holiday/tts/next"));
        session.setAttribute("daily",getDailySentence.get("tts"));
        return modelAndView;
    }

    @RequestMapping(value = "home")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "allBoard")
    public ModelAndView allBoard(ModelAndView modelAndView,HttpSession session, @RequestParam(defaultValue = "0") int pageNum){
        modelAndView.setViewName("allBoard");
        session.setAttribute("boards",announcementService.boards(pageNum));
        return modelAndView;
    }

    @RequestMapping(value = "boardInfo")
    public ModelAndView boardInfo(ModelAndView modelAndView, HttpSession session, String boardId) {
        modelAndView.setViewName("boardInfo");
        session.setAttribute("board", announcementService.getOne(Long.valueOf(boardId)));
        return modelAndView;
    }

    @RequestMapping(value = "boardEdit", method = RequestMethod.GET)
    public ModelAndView boardEdit(ModelAndView modelAndView, HttpSession session, Long boardId) {
        modelAndView.setViewName("boardEdit");
        session.setAttribute("boardEdit", announcementService.getOne(boardId));
        return modelAndView;
    }

    @RequestMapping(value = "boardEdit", method = RequestMethod.POST)
    public ModelAndView boardEdit(ModelAndView modelAndView, HttpSession session, BoardEditVO vo) {
        modelAndView.setViewName("boardInfo");
        announcementService.edit(vo.getBoardId(), vo.getContent());
        session.setAttribute("board", announcementService.getOne(vo.getBoardId()));
        return modelAndView;
    }

    @RequestMapping(value = "boardAdd", method = RequestMethod.GET)
    public ModelAndView boardAdd(ModelAndView modelAndView) {
        modelAndView.setViewName("boardAdd");
        return modelAndView;
    }

    @RequestMapping(value = "boardAdd", method = RequestMethod.POST)
    public ModelAndView boardAdd(ModelAndView modelAndView, HttpSession session, String content) {
        modelAndView.setViewName("allBoard");
        User user = (User) session.getAttribute("userinfo");
        announcementService.add(user.getId(), content);
        session.setAttribute("boards", announcementService.boards(0));
        return modelAndView;
    }

    @RequestMapping(value = "boardDelete", method = RequestMethod.POST)
    public ModelAndView boardDelete(ModelAndView modelAndView,HttpSession session, Long boardId){
        modelAndView.setViewName("allBoard");
        announcementService.delete(boardId);
        session.setAttribute("boards", announcementService.boards(0));
        return modelAndView;
    }

    @RequestMapping(value = "profile")
    public ModelAndView profile(ModelAndView modelAndView){
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @RequestMapping(value = "password", method = RequestMethod.GET)
    public ModelAndView passwordUser(ModelAndView modelAndView) {
        modelAndView.setViewName("password");
        return modelAndView;
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    public ModelAndView modifyPasswordUser(ModelAndView modelAndView, HttpSession session, PasswordVO vo) {
        PasswordDTO dto = new PasswordDTO();
        dto.setVo(vo);
        dto.setUser((User) session.getAttribute("userinfo"));
        modelAndView.addObject("result", userService.modifyPassword(dto));
        modelAndView.setViewName("password");
        return modelAndView;
    }



}
