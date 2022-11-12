package com.g5.g5api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido {
    @EmbeddedId
    private DetallePedidoPK id;
    private int cantidad;
    private double precio;
    private int estado;
}
