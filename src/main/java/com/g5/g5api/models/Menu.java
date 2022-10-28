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
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;
    private String fecha;
    @ElementCollection
    @CollectionTable(name = "menu_detail", joinColumns = @JoinColumn(name = "id_menu"))
    @Column(name = "id_producto")
    private List<Integer> idProductos;

}
