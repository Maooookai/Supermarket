package cn.mirage.supermarket.controller;

import cn.mirage.supermarket.service.StaffService;
import cn.mirage.supermarket.service.SupplierService;
import cn.mirage.supermarket.to.StaffAddDTO;
import cn.mirage.supermarket.to.StaffEditDTO;
import cn.mirage.supermarket.to.SupplierAddDTO;
import cn.mirage.supermarket.to.SupplierEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class HRController {

    StaffService staffService;
    SupplierService supplierService;

    @Autowired
    public HRController(StaffService staffService, SupplierService supplierService) {
        this.staffService = staffService;
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "hr")
    public ModelAndView hr(ModelAndView modelAndView) {
        modelAndView.setViewName("hr");
        return modelAndView;
    }

    @RequestMapping(value = "allStaff")
    public ModelAndView allStaff(ModelAndView modelAndView, @RequestParam(defaultValue = "0") int pageNum, HttpSession session) {
        modelAndView.setViewName("allStaff");
        session.setAttribute("staffs", staffService.list(pageNum));
        return modelAndView;
    }

    @RequestMapping(value = "editStaff", method = RequestMethod.GET)
    public ModelAndView editStaff(ModelAndView modelAndView, HttpSession session, String editId) {
        modelAndView.setViewName("editStaff");
        session.setAttribute("staffInfo", staffService.getOne(Long.valueOf(editId)));
        return modelAndView;
    }

    @RequestMapping(value = "editStaff", method = RequestMethod.POST)
    public ModelAndView editStaff(ModelAndView modelAndView, StaffEditDTO dto) {
        modelAndView.setViewName("allStaff");
        staffService.edit(dto);
        return modelAndView;
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.GET)
    public ModelAndView addStaff(ModelAndView modelAndView) {
        modelAndView.setViewName("addStaff");
        return modelAndView;
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    public ModelAndView addStaff(ModelAndView modelAndView, HttpSession session, StaffAddDTO staffAddDTO) {
        modelAndView.setViewName("allStaff");
        staffService.add(staffAddDTO);
        session.setAttribute("staffs", staffService.list(0));
        return modelAndView;
    }

    @RequestMapping(value = "deleteStaff", method = RequestMethod.GET)
    public ModelAndView deleteStaff(ModelAndView modelAndView, HttpSession session, String editId) {
        staffService.delete(editId);
        modelAndView.setViewName("allStaff");
        session.setAttribute("staffs", staffService.list(0));
        return modelAndView;
    }

    @RequestMapping(value = "allSupplier")
    public ModelAndView allSupplier(ModelAndView modelAndView, @RequestParam(defaultValue = "0") int pageNum, HttpSession session) {
        modelAndView.setViewName("allSupplier");
        session.setAttribute("suppliers", supplierService.list(pageNum));
        return modelAndView;
    }

    @RequestMapping(value = "editSupplier", method = RequestMethod.GET)
    public ModelAndView editSupplier(ModelAndView modelAndView, HttpSession session, String editId) {
        modelAndView.setViewName("editSupplier");
        session.setAttribute("supplierInfo", supplierService.getOne(Long.valueOf(editId)));
        return modelAndView;
    }

    @RequestMapping(value = "editSupplier", method = RequestMethod.POST)
    public ModelAndView editSupplier(ModelAndView modelAndView, SupplierEditDTO dto) {
        modelAndView.setViewName("allSupplier");
        supplierService.edit(dto);
        return modelAndView;
    }

    @RequestMapping(value = "addSupplier", method = RequestMethod.GET)
    public ModelAndView addSupplier(ModelAndView modelAndView) {
        modelAndView.setViewName("addSupplier");
        return modelAndView;
    }

    @RequestMapping(value = "addSupplier", method = RequestMethod.POST)
    public ModelAndView addSupplier(ModelAndView modelAndView, HttpSession session, SupplierAddDTO supplierAddDTO) {
        modelAndView.setViewName("allSupplier");
        supplierService.add(supplierAddDTO);
        session.setAttribute("suppliers", supplierService.list(0));
        return modelAndView;
    }

    @RequestMapping(value = "deleteSupplier", method = RequestMethod.GET)
    public ModelAndView deleteSupplier(ModelAndView modelAndView, HttpSession session, String editId) {
        supplierService.delete(editId);
        modelAndView.setViewName("allSupplier");
        session.setAttribute("suppliers", supplierService.list(0));
        return modelAndView;
    }

}