package com.g5.g5api.service;

import com.g5.g5api.models.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> listarProductos();
    public Producto buscarProducto(Long idProducto);
}
