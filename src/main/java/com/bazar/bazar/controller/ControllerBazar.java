/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bazar.bazar.controller;

import com.bazar.bazar.model.Bazar;
import com.bazar.bazar.service.IBazarServi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sosag
 */
@RestController
public class ControllerBazar {
    @Autowired
    private IBazarServi servi;
    
    
@PostMapping("/productos/crear")
public String crearProducto(@RequestBody Bazar dato){
    System.out.println("metodo del post");
 servi.CrearProducto(dato);
return "Creado";
}








@GetMapping("/productos/traer/{id}")
public Bazar traerPorId(@PathVariable Long id){

return servi.traerProductoId(id);
}



@GetMapping("/productos/traer")
public List<Bazar> muestratodo(){
return servi.TraerLista();

}
    
@GetMapping("/productos/traermayamenprecio")
public List<Bazar> traaerordenado1(){
return servi.tododeMasCaroaMasBarato();

}

@GetMapping("/productos/traermenamayprecio")
public List<Bazar> traaerordenado2(){
    return servi.tododeMasBaratoaMasCaro();
    
}
@GetMapping("/productos/traermayor")
public Bazar traaerMayor(){
    return servi.traerMasCaro();
    
}

@DeleteMapping("/productos/eliminar/{id}")
public String Borrar(@PathVariable Long id){
servi.eliminarValorId(id);
return "Eliminado con exito";
}


@PutMapping("/productos/editar/{id}")
public String Editar( @PathVariable Long id,
                      @RequestParam ("producto") String nuevoproducto,
                      @RequestParam ("precio")  Double  nuevoprecio)  {
Bazar dato=servi.traerProductoId(id);
dato.setId(id);
dato.setPrecio(nuevoprecio);
dato.setProducto(nuevoproducto);
servi.CrearProducto(dato);
//en el servicio save sirve para guardar  nuevo o edita el que existe
// spring lo hace automatico entonces con el save del servicio pisamoe el valor 
//actual y hacemos asi  la edicion de un registro de la BD.
    

return "campo cambiado exitosamente";


}




@GetMapping("/productos/traermenor")
public Bazar traaerMenor(){
    return servi.traerMasBarato();
    
}


}