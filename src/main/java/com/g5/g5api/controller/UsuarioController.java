package com.g5.g5api.controller;

import com.g5.g5api.models.Rol;
import com.g5.g5api.models.Usuario;
import com.g5.g5api.service.RolService;
import com.g5.g5api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Usuario usuarioLogin = usuarioService.loginUsuario(usuario);
        return ResponseEntity.ok(usuarioLogin);
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registro(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = usuarioService.insertarUsuario(usuario);
        return ResponseEntity.ok(usuarioRegistrado);
    }

    @GetMapping("/recuperar")
    public ResponseEntity<String> recuperar(@RequestParam String email) {
        Usuario usuario = usuarioService.recuperarUsuario(email);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Enviado");
    }

    @GetMapping("/rol/{idUsuario}")
    public ResponseEntity<Rol> obtenerRol(@PathVariable int idUsuario) {
        return ResponseEntity.ok(rolService.obtenerRol(idUsuario));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @DeleteMapping("/usuario/{idUsuario}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable int idUsuario) {
        usuarioService.deleteUsuario((long) idUsuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable int idUsuario) {
        return ResponseEntity.ok(usuarioService.getUsuario((long) idUsuario));
    }


}
