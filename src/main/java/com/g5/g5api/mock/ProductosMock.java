package com.g5.g5api.mock;

import com.g5.g5api.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductosMock {
    public List<Producto> listaProductos = new ArrayList<Producto>();

    Producto producto1 = new Producto(0, "Lomo Saltado", "Trozos de lomo de carne, tomate y cebolla, servidos junto a crocantes papas fritas y graneado arroz.", 28.0, 15);
    Producto producto2 = new Producto(1, "Arroz con Pollo", "Arroz verde al culantro, cocinado con presas de pollo y verduras.", 18.0, 10);
    Producto producto3 = new Producto(2, "Pescado Frito", "Plato de carne", 20.0, 10);
    Producto producto4 = new Producto(3, "Papa a la Huancaina", "Plato de carne", 20.0, 10);
    Producto producto5 = new Producto(4, "Arroz Chaufa", "Plato de mariscos", 20.0, 10);
    Producto producto6 = new Producto(5, "Asado de Carne", "Plato de mariscos", 20.0, 10);
    Producto producto7 = new Producto(6, "Pollo al horno", "Plato de vegetales", 20.0, 10);
    Producto producto8 = new Producto(7, "Arroz Chaufa", "Plato de vegetales", 20.0, 10);
    Producto producto9 = new Producto(8, "Causa", "Plato de vegetales", 20.0, 10);
    Producto producto10 = new Producto(9, "Chuleta de Cerdo", "Plato de vegetales", 20.0, 10);
    Producto producto11 = new Producto(10, "Tallarin Saltado de Carne", "Bebida alcohólica", 20.0, 10);
    Producto producto12 = new Producto(11, "Inka Cola 500 ML", "Bebida alcohólica", 20.0, 10);
    Producto producto13 = new Producto(12, "Coca-Cola 500 ML", "Bebida alcohólica", 20.0, 10);

    public ProductosMock() {
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
        listaProductos.add(producto5);
        listaProductos.add(producto6);
        listaProductos.add(producto7);
        listaProductos.add(producto8);
        listaProductos.add(producto9);
        listaProductos.add(producto10);
        listaProductos.add(producto11);
        listaProductos.add(producto12);
        listaProductos.add(producto13);
    }
}
