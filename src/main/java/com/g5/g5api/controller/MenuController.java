package com.g5.g5api.controller;

import com.g5.g5api.models.Menu;
import com.g5.g5api.models.PedidoWatson;
import com.g5.g5api.models.Producto;
import com.g5.g5api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
    public ResponseEntity<List<Producto>> listarProductosMenu() {
        return ResponseEntity.ok(menuService.listarProductosMenu());
    }

    @PutMapping("/menu")
    public ResponseEntity<Menu> actualizarMenu(@RequestBody Menu menu) {
        return ResponseEntity.ok(menuService.actualizarMenu(menu));
    }

    @DeleteMapping("/menu/{idMenu}")
    public ResponseEntity<String> eliminarMenu(@PathVariable String idMenu) {
        menuService.eliminarMenu(idMenu);
        return ResponseEntity.ok("Menu eliminado");
    }

    @GetMapping("/menu/{idMenu}")
    public ResponseEntity<Menu> menuXID(@PathVariable int idMenu) {
        return ResponseEntity.ok(menuService.menuXID(idMenu));
    }

    @GetMapping("/menu/menutoday")
    public ResponseEntity<Menu> menuToday() {
        return ResponseEntity.ok(menuService.menuToday());
    }

    @GetMapping("/menu/productos/watson")
    public PedidoWatson listarProductosMenuDelDiaWatson() {
        List<Producto> productos = menuService.listarProductosMenu();
        String productosWatson = "";
        for (Producto producto : productos) {
            productosWatson += "(" + producto.getIdProducto() + ") "+ producto.getNombre() + ", ";

        }
        PedidoWatson pedidoWatson = new PedidoWatson();
        pedidoWatson.setProductos(productosWatson);
        return pedidoWatson;
    }
}
