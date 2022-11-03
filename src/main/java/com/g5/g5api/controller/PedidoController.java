package com.g5.g5api.controller;

import com.g5.g5api.models.Pedido;
import com.g5.g5api.models.Producto;
import com.g5.g5api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/pedido")
    public Pedido pedidoXID(@RequestParam int idPedido){
        return pedidoService.pedidoXID(idPedido);
    }

    @PutMapping("/pedido")
    public Pedido actualizarPedido(@RequestBody Pedido pedido){
        return pedidoService.actualizarPedido(pedido);
    }

    @DeleteMapping("/pedido")
    public void eliminarPedido(@RequestParam int idPedido){
        pedidoService.eliminarPedido(idPedido);
    }

    @GetMapping("/pedido/productos")
    public List<Producto> listarProductosPedido(@RequestParam int idPedido){
        return pedidoService.listarProductosPedido(idPedido);
    }

}
