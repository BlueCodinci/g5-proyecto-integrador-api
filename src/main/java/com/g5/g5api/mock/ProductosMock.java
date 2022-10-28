package com.g5.g5api.mock;

import com.g5.g5api.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductosMock {
    public List<Producto> listaProductos = new ArrayList<Producto>();

    Producto producto1 = new Producto(1, "Coca-Cola", "Bebida gaseosa", 10.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto2 = new Producto(2, "Pepsi", "Bebida gaseosa", 10.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto3 = new Producto(3, "Lomo Saltado", "Plato de carne", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto4 = new Producto(4, "Arroz con Pollo", "Plato de carne", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto5 = new Producto(5, "Ceviche", "Plato de mariscos", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto6 = new Producto(6, "Pescado Frito", "Plato de mariscos", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto7 = new Producto(7, "Papa a la Huancaina", "Plato de vegetales", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto8 = new Producto(8, "Arroz Chaufa", "Plato de vegetales", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto9 = new Producto(9, "Papa Rellena", "Plato de vegetales", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto10 = new Producto(10, "Causa", "Plato de vegetales", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto11 = new Producto(11, "Pisco Sour", "Bebida alcohólica", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto12 = new Producto(12, "Mojito", "Bebida alcohólica", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");
    Producto producto13 = new Producto(13, "Cerveza", "Bebida alcohólica", 20.0, "https://www.coca-cola.com/content/dam/journey/us/en/global/brands/coca-cola/coca-cola-bottle.png");

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
