package com.malcasebastian.sisgestion.service;

import java.util.List;

import com.malcasebastian.sisgestion.entity.Infraccion;

public interface InfraccionService {
    // Cambiado el nombre de la interfaz a InfraccionService

    public List<Infraccion> findAll();
    public Infraccion findById(Long id);
    public Infraccion findByDescripcion(String descripcion);
    public Infraccion create(Infraccion obj);
    public Infraccion update(Infraccion obj);
    public void delete(Long id);
}
