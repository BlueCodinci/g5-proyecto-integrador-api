package com.g5.g5api.service;

import com.g5.g5api.models.DetallePedido;
import com.g5.g5api.models.Pedido;

import java.util.List;

public interface PedidoService {
    public List<Pedido> listarPedidos();
    public List<Pedido> listarPedidosIdUsuario(int idUsuario);
    public Pedido guardarPedido(Pedido pedido);
    public Pedido pedidoXID(int idPedido);
    public Pedido actualizarPedido(Pedido pedido);
    public void eliminarPedido(int idPedido);
    public List<DetallePedido> listarDetallePedido(int idPedido);
    public List<DetallePedido> insertarDetallePedido(List<DetallePedido> listaDetallePedido);
    public Pedido getPedidoActivoUsuario(int idUsuario);
    List<DetallePedido> actualizarDetallePedido(List<DetallePedido> listaDetallePedido);
    void eliminarDetallePedido(int idPedido, int idProducto);
    void actualizarEstadoPedido(int idPedido, int idEstado);
    public DetallePedido getDetallePedido(int idPedido, int idProducto);
}
