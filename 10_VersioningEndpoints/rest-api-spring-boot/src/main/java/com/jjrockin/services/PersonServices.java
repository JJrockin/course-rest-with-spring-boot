package com.jjrockin.services;

import com.jjrockin.data.vo.v1.PersonVO;
import com.jjrockin.data.vo.v2.PersonVOV2;
import com.jjrockin.exceptions.ResourceNotFoundException;
import com.jjrockin.mapper.ModelMapper;
import com.jjrockin.mapper.custom.PersonMapper;
import com.jjrockin.model.Person;
import com.jjrockin.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper personMapper;

    public List<PersonVO> findAll(){

        logger.info("Finding all people");

        return ModelMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }
    public PersonVO findById(Long id){

        logger.info("Finding one person");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return ModelMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");
        var entity = ModelMapper.parseObject(person, Person.class);
        var vo = ModelMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }
    public PersonVO update(PersonVO person) {
        logger.info("Updating one person");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = ModelMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person with V2!");
        var entity = personMapper.convertVoToEntity(person);
        var vo = personMapper.convertEntityToVo(repository.save(entity));
        return vo;
    }
}
