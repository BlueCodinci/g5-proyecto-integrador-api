package com.g5.g5api.service;

import com.g5.g5api.dao.RolDao;
import com.g5.g5api.models.Menu;
import com.g5.g5api.models.Rol;
import com.g5.g5api.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;

    @Override
    public void insertarRol(Usuario usuario, String rolInsertar) {
        Rol rol = new Rol();
        rol.setNombre(rolInsertar);
        rol.setIdUsuario(usuario.getIdUsuario());
        rolDao.save(rol);
    }

    @Override
    public Rol obtenerRol(int idUsuario) {
        return rolDao.findByIdUsuario((long) idUsuario);
    }
}
