
package com.springboot.disney.controller;

import com.springboot.disney.Model.Pelicula_Serie;
import com.springboot.disney.Service.Pelicula_SerieService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.FormParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cortinez Juan José
 */

@RestController
@RequestMapping("/pelicula_serie")
public class Pelicula_SerieController {
    
    @Autowired
    Pelicula_SerieService pelicula_SerieService;   
    
    @GetMapping("/movies")
   public List<Pelicula_Serie> obtenerPeliculas_Series(){
       return pelicula_SerieService.listarPeliculas_Series();
   }
   
   @GetMapping("/detalle/{id}")
   public Optional<Pelicula_Serie> obtenerDetallePelicula_Serie(@PathVariable int id){
       return pelicula_SerieService.detallePelicula_Serie(id);
   }
   
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
            pelicula_SerieService.eliminarPelicula_Serie(id);
    }
    
    @PostMapping("/agregar")
   public void guardarAgenda(@FormParam("titulo") String titulo,@FormParam("fechaCreacion") Date fechaCreacion,@FormParam("calificacion") int calificacion){
       Pelicula_Serie pelicula_Serie = new Pelicula_Serie(titulo,fechaCreacion,calificacion);
       pelicula_SerieService.guardarPelicula_Serie(pelicula_Serie);
       
   }
    
   @PostMapping("/modificar")
   public void actualizarPelicula_Serie(@FormParam("id") int id,@FormParam("titulo") String titulo,@FormParam("fechaCreacion") Date fechaCreacion,@FormParam("calificacion") int calificacion){
        pelicula_SerieService.modificarPelicula_Serie(titulo, fechaCreacion, calificacion, id);
       
        
   }
   
   @GetMapping("/movies/{nombre}")
   public Pelicula_Serie obtenerPorTitulo(@PathVariable String nombre){
       return pelicula_SerieService.buscarPorTitulo(nombre);
   }

}
