package com.dickanirwansyah.springboot.springbootmybatis;

import com.dickanirwansyah.springboot.springbootmybatis.entity.Person;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MappedTypes(Person.class)
@MapperScan("com.dickanirwansyah.springboot.springbootmybatis.mapper")
@SpringBootApplication
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}
}
