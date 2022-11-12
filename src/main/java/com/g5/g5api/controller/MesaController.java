package com.g5.g5api.controller;

import com.g5.g5api.models.Mesa;
import com.g5.g5api.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MesaController {

    @Autowired
    MesaService mesaService;

    @GetMapping("/mesa")
    public ResponseEntity<Mesa> buscarMesa(@RequestParam String idMesa) {
        Mesa mesa = mesaService.buscarMesa(idMesa);
        if (mesa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mesa);
    }

    @PostMapping("/mesa")
    public ResponseEntity<Mesa> insertarMesa(@RequestBody Mesa mesa) {
        return ResponseEntity.ok(mesaService.insertarMesa(mesa));
    }

    @DeleteMapping("/mesa/{idMesa}")
    public ResponseEntity<Mesa> eliminarMesa(@PathVariable String idMesa) {
        mesaService.deleteMesa(idMesa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/mesa")
    public ResponseEntity<Mesa> actualizarMesa(@RequestBody Mesa mesa) {
        return ResponseEntity.ok(mesaService.updateMesa(mesa));
    }

    @GetMapping("/mesas")
    public ResponseEntity<List<Mesa>> listarMesas() {
        return ResponseEntity.ok(mesaService.listarMesas());
    }

    @GetMapping("/mesa/watson/{idMesa}")
    public String mesaWatson(@PathVariable String idMesa) {
        Mesa mesa = mesaService.buscarMesa(idMesa);
        if (mesa == null) {
            return "-1";
        }

        return mesa.getIdMesa();
    }


}
