package com.plannerofrings.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.plannerofrings.springboot.app.models.entity.Family;

/*Spring Component that implement CrudRepository to operate with the data of the entity Memories
 * Long is the type of the primary key */
public interface IFamilyDao extends CrudRepository<Family, Long> {

}
