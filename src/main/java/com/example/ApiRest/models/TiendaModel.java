package com.example.ApiRest.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tienda")
public class TiendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tienda;
    @ManyToMany
    @JoinTable(
            name = "pelicula_tienda",
            joinColumns = @JoinColumn(name = "id_tienda"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    @JsonIgnore

    public Set<PeliculaModel> peliculas = new HashSet<>();

    @Column
    private String nombreTienda;
    @Column
    private Integer cantidadPelicula;
    @Column
    private String direccion;
    @Column
    private String ciudad;
    @Column
    private Integer numeroEmpleados;

    public Long getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(Long id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public Integer getCantidadPelicula() {
        return cantidadPelicula;
    }

    public void setCantidadPelicula(Integer cantidadPelicula) {
        this.cantidadPelicula = cantidadPelicula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(Integer numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public Set<PeliculaModel> getPelicula() {
        return peliculas;
    }

    public void setPelicula(Set<PeliculaModel> pelicula) {
        this.peliculas = pelicula;
    }
}
