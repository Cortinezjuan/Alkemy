
package com.springboot.disney.Service;

import com.springboot.disney.Model.Pelicula_Serie;
import com.springboot.disney.Repository.Pelicula_SerieRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cortinez Juan José
 */
@Service
public class Pelicula_SerieService {
    
     @Autowired
    Pelicula_SerieRepository pelicula_SerieRepository;      
     
     public List<Pelicula_Serie> listarPeliculas_Series(){
        return (List<Pelicula_Serie>) pelicula_SerieRepository.listarPeliculas_Series();
    }
     
     @Transactional 
    public Pelicula_Serie guardarPelicula_Serie(Pelicula_Serie pelicula_Serie){
        return pelicula_SerieRepository.save(pelicula_Serie);
    }
    
    @Transactional 
    public Pelicula_Serie modificarPelicula_Serie(String titulo,Date fechaCreacion,int calificacion, int id){
        Pelicula_Serie pelicula_Serie = pelicula_SerieRepository.buscarPorId(id);
        pelicula_Serie.setTitulo(titulo);
        pelicula_Serie.setFechaCreacion(fechaCreacion);
        pelicula_Serie.setCalificacion(calificacion);
        return pelicula_SerieRepository.save(pelicula_Serie);
        
    }
    
    @Transactional 
    public void eliminarPelicula_Serie(int id){
        Pelicula_Serie pelicula_Serie = pelicula_SerieRepository.buscarPorId(id);
        pelicula_SerieRepository.delete(pelicula_Serie);
        
    }
    
     public Optional<Pelicula_Serie> detallePelicula_Serie(int id){
        return pelicula_SerieRepository.findById(id);
    }
     
    public Pelicula_Serie buscarPorTitulo(String titulo){
        return pelicula_SerieRepository.buscarPelicula_SeriePorTitulo(titulo);
    } 

}
