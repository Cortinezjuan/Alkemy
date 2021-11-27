
package com.springboot.disney.Service;

import com.springboot.disney.Model.Personaje;
import com.springboot.disney.Repository.PersonajeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cortinez Juan José
 */
@Service
public class PersonajeService {
    
    @Autowired
    PersonajeRepository personajeRepository;        
   
    public List<Personaje> listarPersonajes(){
        return (List<Personaje>) personajeRepository.listarPesonajes();
    }
    
    
    @Transactional 
    public Personaje guardarPersonaje(Personaje personaje){
        return personajeRepository.save(personaje);
    }
    
     @Transactional 
    public Personaje modificarPersonaje(String nombre,int edad,double peso,String historia, int id){
        Personaje personaje = personajeRepository.buscarPorId(id);
        
        personaje.setNombre(nombre);
        personaje.setEdad(edad);
        personaje.setPeso(peso);
        personaje.setHistoria(historia);
               
        return personajeRepository.save(personaje);
    }
    
    @Transactional 
    public void eliminarPersonaje(int id){
        Personaje personaje = personajeRepository.buscarPorId(id);
        personajeRepository.delete(personaje);
    }
    
    public Optional<Personaje> detallePersonaje(int id){
        return personajeRepository.findById(id);
    }
    
    public Personaje buscarPorNombre(String nombre){
        return personajeRepository.buscarPersonaje(nombre);
    }
    
    public List<Personaje> buscarPorEdad(int edad){
        return personajeRepository.listarPesonajesPorEdad();
    }
}
