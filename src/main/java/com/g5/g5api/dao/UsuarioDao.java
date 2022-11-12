package com.g5.g5api.dao;

import com.g5.g5api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndPassword(String email, String password);

    Usuario findByEmail(String email);
}
