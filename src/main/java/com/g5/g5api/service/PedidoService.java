package com.g5.g5api.service;

import com.g5.g5api.models.Pedido;
import com.g5.g5api.models.Producto;

import java.util.List;

public interface PedidoService {
    public List<Pedido> listarPedidos();
    public Pedido guardarPedido(Pedido pedido);
    public Pedido pedidoXID(int idPedido);
    public Pedido actualizarPedido(Pedido pedido);
    public void eliminarPedido(int idPedido);
    public List<Producto> listarProductosPedido(int idPedido);

}
