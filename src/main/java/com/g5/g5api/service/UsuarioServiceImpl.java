package com.g5.g5api.service;

import com.g5.g5api.dao.UsuarioDao;
import com.g5.g5api.models.Rol;
import com.g5.g5api.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private RolService rolService;

    @Override
    public Usuario insertarUsuario(Usuario usuario) {
        usuario = usuarioDao.save(usuario);
        rolService.insertarRol(usuario, "ROLE_CLIENTE");
        return usuario;
    }

    @Override
    public Usuario loginUsuario(Usuario usuario) {
        return usuarioDao.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public void deleteUsuario(Long idUsuario) {
        usuarioDao.delete(usuarioDao.findById(idUsuario).get());
    }

    @Override
    public Usuario recuperarUsuario(String email) {
        return usuarioDao.findByEmail(email);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Long idUsuario) {
        return usuarioDao.findById(idUsuario).get();
    }


}
