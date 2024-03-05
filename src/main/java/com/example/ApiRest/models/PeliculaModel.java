package com.example.ApiRest.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
public class PeliculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String fecha;
    @Column
    private String genero;
    @Column
    private Integer valor;

    @ManyToMany(mappedBy = "pelicula")
    @JsonIgnoreProperties("pelicula")
    private Set<TiendaModel> tienda = new HashSet<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }


    public Set<TiendaModel> getPelicula() {
        return tienda;
    }

    public void setPelicula(Set<TiendaModel> pelicula) {
        this.tienda = pelicula;
    }
}
