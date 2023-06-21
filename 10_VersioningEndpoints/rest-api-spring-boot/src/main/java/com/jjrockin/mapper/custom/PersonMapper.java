package com.jjrockin.mapper.custom;

import com.jjrockin.data.vo.v2.PersonVOV2;
import com.jjrockin.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthday(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }
    public Person convertVoToEntity(PersonVOV2 vo){
        Person person = new Person();
        person.setId(vo.getId());
        person.setAddress(vo.getAddress());
//        person.setBirthday(new Date());
        person.setFirstName(vo.getFirstName());
        person.setLastName(vo.getLastName());
        person.setGender(vo.getGender());
        return person;
    }
}
