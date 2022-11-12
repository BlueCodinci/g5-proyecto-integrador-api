package com.g5.g5api.service;

import com.g5.g5api.dao.DetallePedidoDao;
import com.g5.g5api.dao.PedidoDao;
import com.g5.g5api.mock.ProductosMock;
import com.g5.g5api.models.DetallePedido;
import com.g5.g5api.models.Pedido;
import com.g5.g5api.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao pedidoDao;

    @Autowired
    MenuService menuService;

    @Autowired
    DetallePedidoDao detallePedidoDao;

    @Override
    public List<Pedido> listarPedidos() {
        return (List<Pedido>) pedidoDao.findAll();
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {


        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = DateFor.format(date);

        pedido.setFecha(stringDate);
        pedido.setIdMenu(menuService.menuXFecha(stringDate).getIdMenu());
        pedido.setEstado(0);

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
    public List<DetallePedido> listarDetallePedido(int idPedido) {
        return detallePedidoDao.findByIdIdPedido(idPedido);
    }

    @Override
    public List<DetallePedido> insertarDetallePedido(List<DetallePedido> listaDetallePedido) {
        for (DetallePedido detallePedido : listaDetallePedido) {
            detallePedidoDao.save(detallePedido);
        }
        return listarDetallePedido(listaDetallePedido.get(0).getId().getIdPedido());
    }

}
