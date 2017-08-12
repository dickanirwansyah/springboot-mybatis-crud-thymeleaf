package com.dickanirwansyah.springboot.springbootmybatis.controller;


import com.dickanirwansyah.springboot.springbootmybatis.entity.Person;
import com.dickanirwansyah.springboot.springbootmybatis.mapper.MapperPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping(value = "/dataperson")
@Controller
public class ControllerPerson {

    @Autowired
    private MapperPerson mapperPerson;

    @RequestMapping(value = "/listperson", method = RequestMethod.GET)
    public String getListController(Model model){
        model.addAttribute("title", "List Person");
        model.addAttribute("hello", "Hello Spring MyBatis");
        model.addAttribute("list", mapperPerson.listperson());
        return "index";
    }

    @RequestMapping(value = "/insertperson", method = RequestMethod.GET)
    public String getInsertPerson(Model model){
        model.addAttribute("title", "insert person");
        model.addAttribute("hello", "form insert person");
        return "person/insert";
    }

    @RequestMapping(value = "/insertperson", method = RequestMethod.POST)
    public String getProsesInsert(@ModelAttribute Person person){
        mapperPerson.insertPerson(person);
        return "redirect:/dataperson/listperson";
    }

    @RequestMapping(value = "/updateperson", method = RequestMethod.POST)
    public String getProsesUpdate(@ModelAttribute Person person){
        mapperPerson.updatePerson(person);
        return "redirect:/dataperson/listperson";
    }

    @RequestMapping(value = "/getperson/{idperson}", method = RequestMethod.GET)
    public String getIdperson(@PathVariable("idperson")String idperson, Model model){
        model.addAttribute("title", "update person");
        Person person=mapperPerson.getidperson(idperson);
        model.addAttribute("persons", person);
        return "person/update";
    }

    @RequestMapping(value = "/deleteperson/{idperson}", method = RequestMethod.GET)
    public String getProsesDelete(@PathVariable("idperson")String idperson){
        Person person=new Person();
        person=mapperPerson.getidperson(idperson);
        mapperPerson.deletePerson(idperson);
        return "redirect:/dataperson/listperson";
    }
}
