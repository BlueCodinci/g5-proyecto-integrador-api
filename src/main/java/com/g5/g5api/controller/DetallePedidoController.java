package com.g5.g5api.controller;

import com.g5.g5api.models.DetallePedido;
import com.g5.g5api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DetallePedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedido/detalle/{idPedido}")
    public List<DetallePedido> listarDetallePedido(@PathVariable int idPedido) {
        return pedidoService.listarDetallePedido(idPedido);
    }

    @PostMapping("/pedido/detallepedido")
    public ResponseEntity<List<DetallePedido>> insertarDetallePedido(@RequestBody List<DetallePedido> listaDetallePedido) {
        return ResponseEntity.ok(pedidoService.insertarDetallePedido(listaDetallePedido));
    }

    @PutMapping("/pedido/actualizar/detallepedido")
    public ResponseEntity<List<DetallePedido>> actualizarDetallePedido(@RequestBody List<DetallePedido> listaDetallePedido) {
        return ResponseEntity.ok(pedidoService.actualizarDetallePedido(listaDetallePedido));
    }


    @GetMapping("/pedido/detalle/{idPedido}/{idProducto}")
    public DetallePedido detallePedidoXID(@PathVariable("idPedido") int idPedido, @PathVariable("idProducto") int idProducto) {
        return pedidoService.getDetallePedido(idPedido, idProducto);
    }
}
