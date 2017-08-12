package com.dickanirwansyah.springboot.springbootmybatis.mapper;

import com.dickanirwansyah.springboot.springbootmybatis.entity.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MapperPerson {

    //Mapper Select
    @Select("SELECT* FROM person")
    List<Person> listperson();

    //Mapper Insert
    @Insert("insert into person(idperson, name, sex, adres, phone, birthday) " +
            "values (#{idperson}, #{name}, #{sex}, #{adres}, #{phone}, NOW())")
    void insertPerson(Person person);

    //Mapper Select person berdasarkan idperson
    @Select("SELECT * FROM person WHERE idperson=#{idperson}")
    Person getidperson(String idperson);

    //Mapper delete person berdasarkan idperson
    @Delete("DELETE FROM person WHERE idperson=#{idperson}")
    void deletePerson(String idperson);


    @Update("UPDATE person SET name=#{name}, sex=#{sex}, adres=#{adres}," +
            " phone=#{phone}, birthday=#{birthday} WHERE idperson=#{idperson}")
    void updatePerson(Person person);
}
