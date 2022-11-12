package com.g5.g5api.service;

import com.g5.g5api.dao.DetallePedidoDao;
import com.g5.g5api.dao.PedidoDao;
import com.g5.g5api.mock.ProductosMock;
import com.g5.g5api.models.DetallePedido;
import com.g5.g5api.models.DetallePedidoPK;
import com.g5.g5api.models.Pedido;
import com.g5.g5api.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public List<Pedido> listarPedidosIdUsuario(int idUsuario) {
        return pedidoDao.findByIdUsuario(idUsuario);
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

    @Override
    public Pedido getPedidoActivoUsuario(int idUsuario) {
        List<Pedido> listaPedidos = pedidoDao.findByIdUsuarioAndEstado(idUsuario, 0);
        if (listaPedidos.size() > 0) {
            return listaPedidos.get(listaPedidos.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public List<DetallePedido> actualizarDetallePedido(List<DetallePedido> listaDetallePedido) {
        for (DetallePedido detallePedido : listaDetallePedido) {
            if(detallePedidoDao.findByIdIdPedidoAndIdIdProducto(detallePedido.getId().getIdPedido(), detallePedido.getId().getIdProducto()) != null){
                detallePedido.setCantidad(detallePedido.getCantidad() + detallePedidoDao.findByIdIdPedidoAndIdIdProducto(detallePedido.getId().getIdPedido(), detallePedido.getId().getIdProducto()).getCantidad());
            }
            detallePedidoDao.save(detallePedido);
        }
        return listaDetallePedido;
    }

    @Override
    public void eliminarDetallePedido(int idPedido, int idProducto) {
        detallePedidoDao.deleteByIdIdPedidoAndIdIdProducto(idPedido, idProducto);
    }

    @Override
    public void actualizarEstadoPedido(int idPedido, int idEstado) {
        Pedido pedido = pedidoDao.findById(idPedido).get();
        pedido.setEstado(idEstado);
        pedidoDao.save(pedido);
    }

    @Override
    public DetallePedido getDetallePedido(int idPedido, int idProducto) {
        return detallePedidoDao.findByIdIdPedidoAndIdIdProducto(idPedido, idProducto);
    }

}
