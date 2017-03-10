package com.hai.controller;

import com.hai.base.BaseController;
import com.hai.model.Person;
import com.hai.service.IPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by as on 2017/3/7.
 */
@Controller
@RequestMapping("/person")
public class PersonController extends BaseController {

    @Resource(name = "personService")
    private IPersonService personService;

    @RequestMapping("/list")
    public String persons(Model model) {

        List<Person> persons = this.personService.selectAllPersons();
        model.addAttribute("persons", persons);

        return "persons";
    }

    @RequestMapping("/info")
    public String info(@RequestParam Integer personId, Model model) {

        System.out.println("info personId: " + personId);
        if (null == personId) {
            return "common/errors/error";
        }
        Person person = this.personService.selectByPrimaryKey(personId);
        model.addAttribute("person", person);

        return "person";
    }

    @ResponseBody
    @RequestMapping("/info/{personId}")
    public Person info(@PathVariable Integer personId) {

        Person person = null;
        System.out.println("info personId: " + personId);
        if (null == personId) {
            person = new Person();
        } else {
            person = this.personService.selectByPrimaryKey(personId);
        }

        return person;
    }
/*
    @RequestMapping("/info")
    public String info(HttpServletRequest request, Model model) {

        int personId = Integer.parseInt(request.getParameter("personId"));

        Person person = this.personService.selectByPrimaryKey(personId);
        model.addAttribute("person", person);

        return "person";
    }
*/

    @RequestMapping("/detail/{personId}")
    public String detail(@PathVariable Integer personId, Model model) {
        System.out.println(this.getClass().getName() + ".detail...");
        if (null == personId || personId <= 0) {
            return "common/errors/error";
        }
        System.out.println("personId: " + personId);
        Person person = this.personService.selectByPrimaryKey(personId);
        model.addAttribute("person", person);
        return "detail";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println(this.getClass().getName() + ".delete...");
        this.personService.deleteByPrimaryKey(id);
        return "redirect:/person/list";
    }


}
