package com.g5.g5api.dao;

import com.g5.g5api.models.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePedidoDao extends JpaRepository<DetallePedido, Integer> {
    public List<DetallePedido> findByIdIdPedido(int idPedido);
}
