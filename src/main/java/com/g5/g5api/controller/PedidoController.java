package com.g5.g5api.controller;

import com.g5.g5api.models.DetallePedido;
import com.g5.g5api.models.Pedido;
import com.g5.g5api.models.Producto;
import com.g5.g5api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }

    @PostMapping("/pedido")
    public Pedido guardarPedido(@RequestBody Pedido  pedido){
        return pedidoService.guardarPedido(pedido);
    }

    @GetMapping("/pedido/{idPedido}")
    public Pedido pedidoXID(@PathVariable int idPedido){
        return pedidoService.pedidoXID(idPedido);
    }

    @PutMapping("/pedido")
    public Pedido actualizarPedido(@RequestBody Pedido pedido){
        return pedidoService.actualizarPedido(pedido);
    }

    @DeleteMapping("/pedido/{idPedido}")
    public void eliminarPedido(@PathVariable int idPedido){
        pedidoService.eliminarPedido(idPedido);
    }

    @GetMapping("/pedido/productos")
    public List<DetallePedido> listarProductosPedido(@RequestParam int idPedido){
        return pedidoService.listarDetallePedido(idPedido);
    }

    @PostMapping("/pedido/detallepedido")
    public ResponseEntity<List<DetallePedido>> insertarDetallePedido(@RequestBody List<DetallePedido> listaDetallePedido){
        return ResponseEntity.ok(pedidoService.insertarDetallePedido(listaDetallePedido));
    }

}
