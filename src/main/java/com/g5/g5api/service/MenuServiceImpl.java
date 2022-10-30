package com.g5.g5api.service;

import com.g5.g5api.dao.MenuDao;
import com.g5.g5api.mock.ProductosMock;
import com.g5.g5api.models.Menu;
import com.g5.g5api.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> listarMenus() {
        return (List<Menu>) menuDao.findAll();
    }

    @Override
    public Menu guardarMenu(Menu menu) {
        return menuDao.save(menu);
    }

    @Override
    public Menu menuXFecha(String fecha) {
        return menuDao.findByFecha(fecha).get(menuDao.findByFecha(fecha).size() - 1);
    }

    @Override
    public Menu menuXID(int idMenu) {
        return menuDao.findById(idMenu).get();
    }

    @Override
    public Menu actualizarMenu(Menu menu) {
        return menuDao.save(menu);
    }

    @Override
    public void eliminarMenu(String idMenu) {
        menuDao.deleteById(Integer.parseInt(idMenu));
    }

    @Override
    public List<Producto> listarProductosMenu(String fecha) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Menu menu = menuXFecha(fecha);

        for (Integer p : menu.getIdProductos()) {
            listaProductos.add(new ProductosMock().listaProductos.get(p));
        }

        return listaProductos;
    }

    @Override
    public List<Producto> listarProductos() {
        return new ProductosMock().listaProductos;
    }
}
