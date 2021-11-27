
package com.springboot.disney.Model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 * @author Cortinez Juan José
 */
@Entity
public class Pelicula_Serie {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private byte[] imgagen = new byte[8096];
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    private int calificacion;
     @ManyToMany(
    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "peliculas_series",
    targetEntity = Personaje.class)
    private List<Personaje> personajes;

    public Pelicula_Serie() {
    }

    public Pelicula_Serie(String titulo, Date fechaCreacion, int calificacion) {
        
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        
    }
    
     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getImgagen() {
        return imgagen;
    }

    public void setImgagen(byte[] imgagen) {
        this.imgagen = imgagen;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
    
    
}
