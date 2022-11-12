package com.g5.g5api.controller;

import com.g5.g5api.models.*;
import com.g5.g5api.service.PedidoService;
import com.g5.g5api.service.ProductoService;
import com.g5.g5api.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ProductoService productoService;

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

    @PostMapping("/pedido/watson")
    public Pedido insertarWatson(@RequestBody PedidoWatson pedido){
        ArrayList<Integer> listaProductos = new ArrayList<>();
        // el texto contiene numeros separados por comas que representan los id de los productos
        // se debe crear un pedido y agregarle los productos
        // Separar los numeros y crear un array de enteros
        String[] array = pedido.getProductos().split(",");
        for(String s : array){
            listaProductos.add(Integer.parseInt(s));
        }
        // Crear el pedido
        Pedido pedidoNuevo = new Pedido();
        pedidoNuevo.setIdUsuario(pedido.getIdUsario());

        pedidoNuevo = pedidoService.guardarPedido(pedidoNuevo);
        // Crear los detalles del pedido
        ArrayList<DetallePedido> listaDetallePedido = new ArrayList<>();
        for(Integer i : listaProductos){
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setId(new DetallePedidoPK(pedidoNuevo.getIdPedido(), i));
            detallePedido.setCantidad(1);
            detallePedido.setPrecio(productoService.buscarProducto(Long.valueOf(i)).getPrecio());
            listaDetallePedido.add(detallePedido);
        }

        pedidoService.insertarDetallePedido(listaDetallePedido);

        return pedidoNuevo;
    }

}
