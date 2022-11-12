package com.g5.g5api.controller;

import com.g5.g5api.models.*;
import com.g5.g5api.service.PedidoService;
import com.g5.g5api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ProductoService productoService;

    @GetMapping("/pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping("/pedido")
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    @GetMapping("/pedido/{idPedido}")
    public Pedido pedidoXID(@PathVariable int idPedido) {
        return pedidoService.pedidoXID(idPedido);
    }

    @PutMapping("/pedido")
    public Pedido actualizarPedido(@RequestBody Pedido pedido) {
        return pedidoService.actualizarPedido(pedido);
    }

    @DeleteMapping("/pedido/{idPedido}")
    public void eliminarPedido(@PathVariable int idPedido) {
        pedidoService.eliminarPedido(idPedido);
    }



    @PostMapping("/pedido/watson")
    public Pedido insertarWatson(@RequestBody PedidoWatson pedido) {
        ArrayList<Integer> listaProductos = new ArrayList<>();
        // el texto contiene numeros separados por comas que representan los id de los productos
        // se debe crear un pedido y agregarle los productos
        // Separar los numeros y crear un array de enteros
        String[] array = pedido.getProductos().split(",");
        for (String s : array) {
            listaProductos.add(Integer.parseInt(s));
        }
        // Crear el pedido
        Pedido pedidoNuevo = new Pedido();
        pedidoNuevo.setIdUsuario(pedido.getIdUsario());

        pedidoNuevo = pedidoService.guardarPedido(pedidoNuevo);
        // Crear los detalles del pedido
        ArrayList<DetallePedido> listaDetallePedido = new ArrayList<>();
        for (Integer i : listaProductos) {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setId(new DetallePedidoPK(pedidoNuevo.getIdPedido(), i));
            detallePedido.setCantidad(1);
            detallePedido.setPrecio(productoService.buscarProducto(Long.valueOf(i)).getPrecio());
            listaDetallePedido.add(detallePedido);
        }

        pedidoService.insertarDetallePedido(listaDetallePedido);

        return pedidoNuevo;
    }

    @GetMapping("/pedido/activo/{idUsuario}")
    public Pedido pedidoActivo(@PathVariable int idUsuario) {
        return pedidoService.getPedidoActivoUsuario(idUsuario);
    }



    @DeleteMapping("/pedido/eliminar/detallepedido/{idPedido}/{idProducto}")
    public void eliminarDetallePedido(@PathVariable("idPedido") int idPedido, @PathVariable("idProducto") int idProducto) {
        pedidoService.eliminarDetallePedido(idPedido, idProducto);
    }

    @PutMapping("/pedido/actualizar/estado/{idPedido}/{estado}")
    public void actualizarEstadoPedido(@PathVariable("idPedido") int idPedido, @PathVariable("estado") int estado) {
        pedidoService.actualizarEstadoPedido(idPedido, estado);
    }

    @GetMapping("/pedidos/usuario/{idUsuario}")
    public List<Pedido> listarPedidosUsuario(@PathVariable int idUsuario) {
        return pedidoService.listarPedidosIdUsuario(idUsuario);
    }

}
