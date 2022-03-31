/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bazar.bazar.service;

import com.bazar.bazar.model.Bazar;
import com.bazar.bazar.repository.IBazarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sosag
 */
@Service
public class ServiBazar implements IBazarServi {
    
    
    @Autowired
    private IBazarRepository mirepo;
    
    
    
    

    @Override
    public List<Bazar> TraerLista() {
        return mirepo.findAll();
    }

    @Override
    public String eliminarValorId(Long id) {
     mirepo.deleteById(id);
     return "Se elimino el producto";
    }

    @Override
    public void CrearProducto(Bazar info){
    mirepo.save(info);
    
    
    }
    
    @Override
    public Bazar traerProductoId(Long id) {
    return mirepo.findById(id).orElse(null);
    }

    @Override
    public Bazar traerMasBarato() {
        return mirepo.traerMenor();
    }

    @Override
    public Bazar traerMasCaro() {
        return mirepo.traerMayor();
    }

    @Override
    public List<Bazar> tododeMasCaroaMasBarato() {
    return mirepo.TraerBazardeMasCaroaMasBarato();
    }

    @Override
    public List<Bazar> tododeMasBaratoaMasCaro() {
    return mirepo.TraerBazardeMasBaratoaMasCaro();
    }
    
}
