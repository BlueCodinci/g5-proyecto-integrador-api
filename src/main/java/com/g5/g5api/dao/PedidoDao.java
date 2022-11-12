package com.g5.g5api.dao;

import com.g5.g5api.models.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoDao extends CrudRepository<Pedido, Integer> {
    public List<Pedido> findByIdUsuarioAndEstado(int idUsuario, int estado);
    List<Pedido> findByIdUsuario(int idUsuario);
}
