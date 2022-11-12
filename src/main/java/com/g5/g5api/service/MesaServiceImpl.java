package com.g5.g5api.service;

import com.g5.g5api.dao.MesaDao;
import com.g5.g5api.models.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    MesaDao mesaDao;

    @Override
    public Mesa insertarMesa(Mesa mesa) {
        return mesaDao.save(mesa);
    }

    @Override
    public List<Mesa> listarMesas() {
        return mesaDao.findAll();
    }

    @Override
    public Mesa updateMesa(Mesa mesa) {
        return mesaDao.save(mesa);
    }

    @Override
    public void deleteMesa(String idMesa) {
        mesaDao.delete(buscarMesa(idMesa));
    }

    @Override
    public Mesa buscarMesa(String idMesa) {
        Optional<Mesa> mesa = mesaDao.findById(idMesa);
        if (mesa.isPresent()) {
            return mesa.get();
        }
        return null;
    }
}
