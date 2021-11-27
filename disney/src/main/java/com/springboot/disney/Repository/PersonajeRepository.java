
package com.springboot.disney.Repository;

import com.springboot.disney.Model.Personaje;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 * @author Cortinez Juan José
 */
public interface PersonajeRepository extends CrudRepository<Personaje, Integer> {
    
    @Query("SELECT p.Imagen, p.Nombre FROM Personaje p")
    public List<Personaje> listarPesonajes();
    
    @Query("SELECT p FROM Personaje p WHERE p.id = :id")
    public Personaje buscarPorId(@Param("id")int id);
    
    @Query("SELECT p FROM Personaje p WHERE p.nombre = :nombre")
    public Personaje buscarPersonaje(@Param("nombre")String nombre);
        
    @Query("SELECT p FROM Personaje p Where p.edad = :edad")
    public List<Personaje> listarPesonajesPorEdad();
}
