package com.g5.g5api.service;

import com.g5.g5api.dao.MenuDao;
import com.g5.g5api.mock.ProductosMock;
import com.g5.g5api.models.Menu;
import com.g5.g5api.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        List<Producto> productos = new ProductosMock().listaProductos;

        if(!menu.getFecha().matches("\\d{4}-\\d{2}-\\d{2}")) {
            return null;
        }

        for (int idProducto : menu.getIdProductos()) {
            if(!productos.stream().anyMatch(producto -> producto.getIdProducto() == idProducto)) {
                return null;
            }
        }

        return menuDao.save(menu);
    }

    @Override
    public Menu menuXFecha(String fecha) {

        List<Menu> menus = menuDao.findByFecha(fecha);

        if(menus.size() > 0) {
            return menus.get(menuDao.findByFecha(fecha).size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public Menu menuXID(int idMenu) {
        return menuDao.findById(idMenu).get();
    }

    @Override
    public Menu actualizarMenu(Menu menu) {
        List<Producto> productos = new ProductosMock().listaProductos;

        if( !menuDao.findById(menu.getIdMenu()).isPresent()) {
            return null;
        }

        if(!menu.getFecha().matches("\\d{4}-\\d{2}-\\d{2}")) {
            return null;
        }

        for (int idProducto : menu.getIdProductos()) {
            if(!productos.stream().anyMatch(producto -> producto.getIdProducto() == idProducto)) {
                return null;
            }
        }

        return menuDao.save(menu);
    }

    @Override
    public boolean eliminarMenu(String idMenu) {
        if( !menuDao.findById(Integer.valueOf(idMenu)).isPresent()) {
            return false;
        }

        menuDao.deleteById(Integer.parseInt(idMenu));
        return true;
    }

    @Override
    public List<Producto> listarProductosMenu() {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = DateFor.format(date);

        Menu menu = menuXFecha(stringDate);

        if (menu != null) {
            for (Integer p : menu.getIdProductos()) {
                listaProductos.add(new ProductosMock().listaProductos.get(p));
            }
        }

        return listaProductos;
    }

    @Override
    public Menu menuToday() {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = DateFor.format(date);

        return menuXFecha(stringDate);
    }

    @Override
    public List<Producto> listarProductos() {
        return new ProductosMock().listaProductos;
    }
}
