package com.example.ApiRest.services;

import com.example.ApiRest.models.PeliculaModel;
import com.example.ApiRest.models.TiendaModel;
import com.example.ApiRest.repositories.ITiendaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class TiendaService {

    @Autowired
    ITiendaRepositorie tiendaRepositorie;

    //Get
    public ArrayList<TiendaModel> getTienda(){
        return (ArrayList<TiendaModel>) tiendaRepositorie.findAll();
    }

    //Post
    public  TiendaModel saveTienda(TiendaModel tienda){
        return tiendaRepositorie.save(tienda);
    }

    //Get id
    public Optional<TiendaModel> getById(Long id){
        return tiendaRepositorie.findById(id);
    }

    //Put (Update)
    public TiendaModel updateByIdTienda(TiendaModel request, Long id){
        TiendaModel tienda = tiendaRepositorie.findById(id).get();

        tienda.setNombreTienda(request.getNombreTienda());
        tienda.setCiudad(request.getCiudad());
        tienda.setDireccion(request.getDireccion());
        tienda.setCantidadPelicula(request.getCantidadPelicula());
        tienda.setNumeroEmpleados(request.getNumeroEmpleados());

        return  tienda;
    }

    public Boolean deleteTienda(Long id){
        try
        {
            tiendaRepositorie.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
