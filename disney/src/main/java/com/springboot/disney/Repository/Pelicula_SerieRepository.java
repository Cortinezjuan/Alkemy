
package com.springboot.disney.Repository;

import com.springboot.disney.Model.Pelicula_Serie;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Cortinez Juan José
 */
public interface Pelicula_SerieRepository extends CrudRepository<Pelicula_Serie, Integer> {
    
    @Query("SELECT p.Imagen, p.Titulo, p.FechaCreacion  FROM Pelicula_Serie p")
    public List<Pelicula_Serie> listarPeliculas_Series();
    
    @Query("SELECT p FROM Pelicula_Serie p WHERE p.id = :id")
    public Pelicula_Serie buscarPorId(@Param("id")int id);
    
    @Query("SELECT p FROM Pelicula_Serie p WHERE p.titulo = :titulo")
    public Pelicula_Serie buscarPelicula_SeriePorTitulo(@Param("titulo")String titulo);
    
    @Query("SELECT p FROM Pelicula_Serie p WHERE p.idGenero = :idGenero")
    public Pelicula_Serie buscarPorIdGenero(@Param("titulo")String titulo);
    
    @Query("SELECT p FROM Pelicula_Serie p ORDER BY p.fechaCreacion ACS")
    public Pelicula_Serie buscarPorFechaCreacion(@Param("ASC")String oder);

}
