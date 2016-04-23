package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;

import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeesService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class EmployeesController {

    @Autowired
    EmployeesService employeesService;

    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/empDep", method = RequestMethod.POST)
    public ModelAndView showAll(@RequestParam(required = false) Integer id) throws SQLException {   //????????? ID ?????????? ?? ??????? ??????? "?????????? ?????? ??????????"
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", departmentService.getById(id));
    }


    @RequestMapping(value = "/empAdd", method = RequestMethod.POST)
    public ModelAndView showAdd(@RequestParam(required = true) Integer id) throws SQLException {
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "department", departmentService.getById(id));
    }


    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) Integer id, String firstName, String secondName) throws SQLException {
        Department dep = departmentService.getById(id);
        Employee addedEmployee = new Employee();
        addedEmployee.setFirstName(firstName);
        addedEmployee.setSecondName(secondName);
        addedEmployee.setDepartment(dep);
        employeesService.insert(addedEmployee);
        return "redirect:/empIntermediate?id=" + dep.getId();
    }


    @RequestMapping(value = "/empDeletePost", method = RequestMethod.POST)
    public String deletePost(@RequestParam(required = true) Integer empId, Integer depId) throws SQLException {
        Department dep = departmentService.getById(depId);
        employeesService.delete(employeesService.getById(empId));
        return "redirect:/empIntermediate?id=" + dep.getId();
    }


    @RequestMapping(value = "/empEdit", method = RequestMethod.POST)
    public ModelAndView showEdit(Integer id) throws SQLException {
        return new ModelAndView(JspPath.EMPLOYEE_EDIT, "employee", employeesService.getById(id));
    }

    @RequestMapping(value = "/empSaveEdit", method = RequestMethod.POST)
    public String EditOne(@RequestParam(required = true) String firstName, String secondName, Integer empId, Integer depId) throws SQLException {
        Employee employee = employeesService.getById(empId);
        Department department = departmentService.getById(depId);
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        employee.setDepartment(department);
        employeesService.update(employee);
        return "redirect:/empIntermediate?id=" + department.getId();
    }

    @RequestMapping(value = "/empIntermediate", method = RequestMethod.GET)
    public ModelAndView IntermediatePageDep(Integer id) throws SQLException {
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", departmentService.getById(id));
    }

}
