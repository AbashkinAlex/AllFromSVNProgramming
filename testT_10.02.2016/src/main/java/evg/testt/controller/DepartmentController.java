package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Collections;
import java.util.*;

import java.sql.SQLException;

@Controller
public class   DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {


        List<Department> departments;


        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.POST)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name) {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        try {
            departmentService.insert(addedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/depIntermediate";
    }



    //Переделываю до ПОСТ запроса


    @RequestMapping(value = "/depDeletePost", method = RequestMethod.POST)
    public String deletePost(@RequestParam(required = true) Integer id) {

        try {
            departmentService.delete(departmentService.getById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/depIntermediate";
    }







    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView showEdit(Integer id) throws SQLException {
        return new ModelAndView(JspPath.DEPARTMENT_EDIT, "addedDepartment", departmentService.getById(id));
    }

    @RequestMapping(value = "/depSaveEdit", method = RequestMethod.POST)
    public String EditOne(@RequestParam(required = true) String name, Integer id) throws SQLException {
        Department addedDepartment = departmentService.getById(id);
        addedDepartment.setName(name);
        departmentService.update(addedDepartment);
        return "redirect:/depIntermediate";
    }

    @RequestMapping(value = "/depIntermediate", method = RequestMethod.GET)
    public ModelAndView IntermediatePageDep() throws SQLException {
        return new ModelAndView(JspPath.DEPARTMENT_ALL,"departments", departmentService.getAll());
    }

}
