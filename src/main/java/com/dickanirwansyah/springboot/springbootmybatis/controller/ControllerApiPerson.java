package com.dickanirwansyah.springboot.springbootmybatis.controller;

import com.dickanirwansyah.springboot.springbootmybatis.entity.Person;
import com.dickanirwansyah.springboot.springbootmybatis.mapper.MapperPerson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class ControllerApiPerson {


    private MapperPerson mapperPerson;

    public ControllerApiPerson(MapperPerson mapperPerson){
        this.mapperPerson=mapperPerson;
    }

    @RequestMapping(value = "/restlistperson", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> findAllPerson(){
        return mapperPerson.listperson();
    }

    @RequestMapping(value = "/restinsertperson", method = RequestMethod.POST)
    @ResponseBody
    public Person insertPerson(){
        Person person=new Person();

        return person;
    }

    @RequestMapping(value = "/restpersonsex", method = RequestMethod.GET)
    @ResponseBody
    public Person getSexPerson(){
        return insertPerson();
    }
}
