/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bazar.bazar.repository;

import com.bazar.bazar.model.Bazar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 *
 * @author sosag
 */
@Repository 
public interface IBazarRepository extends JpaRepository<Bazar, Long>{

 @Query(value="select * from bazar.bazar ORDER BY bazar.precio ASC ",nativeQuery = true)
    List<Bazar> TraerBazardeMasBaratoaMasCaro();
    
    @Query(value="select * from bazar.bazar ORDER BY bazar.precio DESC ",nativeQuery = true)
    List<Bazar> TraerBazardeMasCaroaMasBarato();
    
    
    @Query(value="SELECT bazar.id,bazar.producto,MAX(bazar.precio) AS precio FROM bazar.bazar;  ",nativeQuery = true)
    Bazar traerMayor();
    
    @Query(value="SELECT bazar.id,bazar.producto,MIN(bazar.precio) AS precio FROM bazar.bazar;  ",nativeQuery = true)
    Bazar traerMenor();
    
    
    
    
}
