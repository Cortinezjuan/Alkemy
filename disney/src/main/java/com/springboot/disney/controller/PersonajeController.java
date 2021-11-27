
package com.springboot.disney.controller;

import com.springboot.disney.Model.Personaje;
import com.springboot.disney.Service.PersonajeService;
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
@RequestMapping("/personajes")
public class PersonajeController {
    
    @Autowired
    PersonajeService personajeService;        
  
    
    @GetMapping("/characters")
   public List<Personaje> obtenerPersonajes(){
       return personajeService.listarPersonajes();
   }
   
    @GetMapping("/characters/{id}")
   public Optional<Personaje> obtenerDetallePersonaje(@PathVariable int id){
       return personajeService.detallePersonaje(id);
   }
   
   @GetMapping("/characters/{nombre}")
   public Personaje obtenerPersonajeXNombre(@PathVariable String nombre){
       return personajeService.buscarPorNombre(nombre);
   }
   
   @GetMapping("/characters/{edad}")
   public List<Personaje> obtenerPersonajeXEdad(@PathVariable int edad){
       return personajeService.buscarPorEdad(edad);
   }
   
   @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
            personajeService.eliminarPersonaje(id);
    }
    
    @PostMapping("/agregar")
   public void guardarAgenda(@FormParam("nombre") String nombre,@FormParam("edad") int edad,@FormParam("peso") double peso,@FormParam("historia") String historia){
       Personaje personaje = new Personaje(nombre,edad,peso,historia);
        
       personajeService.guardarPersonaje(personaje);
   }
   
   @PostMapping("/modificar")
   public void actualizarPersonaje(@FormParam("id") int id,@FormParam("nombre") String nombre,@FormParam("edad") int edad,@FormParam("peso") double peso,@FormParam("historia") String historia){
        
        personajeService.modificarPersonaje(nombre, edad, peso, historia, id);
        
   }

}
