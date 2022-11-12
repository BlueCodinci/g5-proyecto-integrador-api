package com.g5.g5api.dao;

import com.g5.g5api.models.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface DetallePedidoDao extends JpaRepository<DetallePedido, Integer> {
    public List<DetallePedido> findByIdIdPedido(int idPedido);

    @Transactional
    @Modifying
    public void deleteByIdIdPedidoAndIdIdProducto(int idPedido, int idProducto);
    public DetallePedido findByIdIdPedidoAndIdIdProducto(int idPedido, int idProducto);
}
