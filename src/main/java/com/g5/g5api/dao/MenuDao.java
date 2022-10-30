package com.g5.g5api.dao;

import com.g5.g5api.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuDao extends CrudRepository<Menu, Integer> {

    List<Menu> findByFecha(String fecha);
}
