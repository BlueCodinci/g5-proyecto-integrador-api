package com.g5.g5api.service;

import com.g5.g5api.models.Rol;
import com.g5.g5api.models.Usuario;

import java.util.List;

public interface UsuarioService {
    public Usuario insertarUsuario(Usuario usuario);
    public Usuario loginUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public void deleteUsuario(Long idUsuario);
    public Usuario recuperarUsuario(String email);
    public List<Usuario> obtenerUsuarios();
    public Usuario getUsuario(Long idUsuario);

}
