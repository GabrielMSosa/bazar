/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bazar.bazar.service;

import com.bazar.bazar.model.Bazar;
import java.util.List;

/**
 *
 * @author sosag
 */
public interface IBazarServi {

public List<Bazar> TraerLista();

public void  CrearProducto(Bazar info);

public String eliminarValorId(Long id);



public Bazar traerProductoId(Long id);

public Bazar traerMasBarato();

public Bazar traerMasCaro();

public List<Bazar> tododeMasCaroaMasBarato();

public List<Bazar> tododeMasBaratoaMasCaro();

    
}
