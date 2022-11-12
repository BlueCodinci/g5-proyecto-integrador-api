package com.g5.g5api.service;

import com.g5.g5api.models.Rol;
import com.g5.g5api.models.Usuario;

public interface RolService {
    public void insertarRol(Usuario usuario, String rolInsertar);
    public Rol obtenerRol(int idUsuario);
}
