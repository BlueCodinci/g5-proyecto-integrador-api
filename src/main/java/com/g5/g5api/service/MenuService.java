package com.g5.g5api.service;

import com.g5.g5api.models.Menu;
import com.g5.g5api.models.Producto;

import java.util.List;

public interface MenuService {

    public List<Menu> listarMenus();
    public Menu guardarMenu(Menu menu);
    public Menu menuXFecha(String fecha);
    public Menu menuXID(int idMenu);
    public Menu actualizarMenu(Menu menu);
    public void eliminarMenu(String idMenu);

    public List<Producto> listarProductosMenu(String fecha);

    public List<Producto> listarProductos();
}
