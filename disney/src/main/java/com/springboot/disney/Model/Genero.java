
package com.springboot.disney.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;

/**
 * @author Cortinez Juan José
 */
@Entity
public class Genero {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private byte[] imgagen = new byte[8096];
   
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Pelicula_Serie")
    private List<Pelicula_Serie> peliculas_Series;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImgagen() {
        return imgagen;
    }

    public void setImgagen(byte[] imgagen) {
        this.imgagen = imgagen;
    }

    public List<Pelicula_Serie> getPeliculas_Series() {
        return peliculas_Series;
    }

    public void setPeliculas_Series(List<Pelicula_Serie> peliculas_Series) {
        this.peliculas_Series = peliculas_Series;
    }
    
    

}
