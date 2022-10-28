package com.g5.g5api.dao;

import com.g5.g5api.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuDao extends CrudRepository<Menu, Integer> {

    Menu findByFecha(String fecha);
}
