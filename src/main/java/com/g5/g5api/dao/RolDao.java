package com.g5.g5api.dao;

import com.g5.g5api.models.Rol;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RolDao extends CrudRepository<Rol, Long> {
    public Rol findByIdUsuario(Long idUsuario);
}
