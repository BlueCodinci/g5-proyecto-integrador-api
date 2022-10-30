package com.g5.g5api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    private int idMenu;
    private int idUsuario;
    private String fecha;
    private int estado;
    private double total;
    @ElementCollection
    private List<Integer> idProductos;
}
