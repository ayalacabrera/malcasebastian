package com.malcasebastian.sisgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malcasebastian.sisgestion.entity.Infraccion;

import java.util.List;

@Repository
public interface InfraccionRepository extends JpaRepository<Infraccion, Long> {
    // Cambiado el nombre de la interfaz a InfraccionRepository
    // Método para buscar una infracción por su descripción
    public Infraccion findByDescripcion(String descripcion);
    // Método para buscar infracciones que contengan una cierta descripción
    public List<Infraccion> findByDescripcionContaining(String descripcion);
}