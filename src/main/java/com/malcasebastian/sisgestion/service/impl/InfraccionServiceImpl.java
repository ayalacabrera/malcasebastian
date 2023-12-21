package com.malcasebastian.sisgestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malcasebastian.sisgestion.entity.Infraccion;
import com.malcasebastian.sisgestion.repository.InfraccionRepository;
import com.malcasebastian.sisgestion.service.InfraccionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfraccionServiceImpl implements InfraccionService {
    // Cambiado el nombre de la implementación a InfraccionServiceImpl

    @Autowired
    private InfraccionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Infraccion> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            //log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Infraccion findById(Long id) {
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            //log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Infraccion findByDescripcion(String descripcion) {
        try {
            return repository.findByDescripcion(descripcion);
        } catch (Exception e) {
            //log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public Infraccion create(Infraccion obj) {
        try {
            return repository.save(obj);
        } catch (Exception e) {
            //log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public Infraccion update(Infraccion obj) {
        try {
            Infraccion infraccionDb = findById(obj.getId());
            if (infraccionDb != null) {
                infraccionDb.setDni(obj.getDni());
                infraccionDb.setFecha(obj.getFecha());
                infraccionDb.setPlaca(obj.getPlaca());
                infraccionDb.setInfraccion(obj.getInfraccion());
                infraccionDb.setDescripcion(obj.getDescripcion());

                return repository.save(infraccionDb);
            } else {
                // Puedes manejar la lógica si la infracción no se encuentra
                return null;
            }
        } catch (Exception e) {
            //log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            Infraccion infraccionDb = findById(id);
            if (infraccionDb != null) {
                repository.delete(infraccionDb);
            }
        } catch (Exception e) {
            //log.error(e.getMessage());
            throw e;
        }
    }
}
