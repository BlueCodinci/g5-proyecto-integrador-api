package com.g5.g5api.service;

import com.g5.g5api.mock.ProductosMock;
import com.g5.g5api.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Override
    public List<Producto> listarProductos() {
        return new ProductosMock().listaProductos;
    }

    @Override
    public Producto buscarProducto(Long idProducto) {
        List<Producto> listaProductos = new ProductosMock().listaProductos;
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        return null;
    }
}
