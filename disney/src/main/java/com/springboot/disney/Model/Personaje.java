
package com.springboot.disney.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Cortinez Juan José
 */
@Entity
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private byte[] imgagen = new byte[8096];
    private int edad;
    private double peso;
    private String historia;
    @ManyToMany(fetch=FetchType.LAZY,
    targetEntity=Pelicula_Serie.class,
    cascade=CascadeType.ALL)
    @JoinTable(
    name="PERSONAJE_PELICULA_SERIE",
    joinColumns=@JoinColumn(name="PERSONAJE_ID"),
    inverseJoinColumns=@JoinColumn(name="PELICULA_SERIE_ID"))
    private List<Pelicula_Serie> peliculas_series;

    public Personaje( String nombre, int edad, double peso, String historia) {
        
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
       
    }

    public Personaje() {
    }

    
    
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<Pelicula_Serie> getPeliculas_series() {
        return peliculas_series;
    }

    public void setPeliculas_series(List<Pelicula_Serie> peliculas_series) {
        this.peliculas_series = peliculas_series;
    }
    
    

}
