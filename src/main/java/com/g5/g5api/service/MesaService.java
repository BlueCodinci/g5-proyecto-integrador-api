package com.g5.g5api.service;

import com.g5.g5api.models.Mesa;

import java.util.List;

public interface MesaService {
    public Mesa insertarMesa(Mesa mesa);
    public List<Mesa> listarMesas();
    public Mesa updateMesa(Mesa mesa);
    public void deleteMesa(String idMesa);
    public Mesa buscarMesa(String idMesa);

}
