package com.g5.g5api.controller;

import com.g5.g5api.models.Menu;
import com.g5.g5api.models.Producto;
import com.g5.g5api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public ResponseEntity<List<Menu>> listarMenus() {
        return ResponseEntity.ok(menuService.listarMenus());
    }

    @PostMapping("/menu")
    public ResponseEntity<Menu> guardarMenu(@RequestBody Menu menu) {
        return ResponseEntity.ok(menuService.guardarMenu(menu));
    }

    @GetMapping("/menu/productos")
    public ResponseEntity<List<Producto>> listarProductosMenu(@RequestParam String fecha) {
        return ResponseEntity.ok(menuService.listarProductosMenu(fecha));
    }



}
