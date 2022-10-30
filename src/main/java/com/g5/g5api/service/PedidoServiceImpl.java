package com.g5.g5api.service;

import com.g5.g5api.dao.PedidoDao;
import com.g5.g5api.mock.ProductosMock;
import com.g5.g5api.models.Menu;
import com.g5.g5api.models.Pedido;
import com.g5.g5api.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao pedidoDao;

    @Override
    public List<Pedido> listarPedidos() {
        return (List<Pedido>) pedidoDao.findAll();
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoDao.save(pedido);
    }

    @Override
    public Pedido pedidoXID(int idPedido) {
        return pedidoDao.findById(idPedido).get();
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return pedidoDao.save(pedido);
    }

    @Override
    public void eliminarPedido(int idPedido) {
        pedidoDao.deleteById(idPedido);
    }

    @Override
    public List<Producto> listarProductosPedido(int idPedido) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Pedido pedido = pedidoXID(idPedido);

        for (Integer p : pedido.getIdProductos()) {
            listaProductos.add(new ProductosMock().listaProductos.get(p));
        }

        return listaProductos;
    }
}
