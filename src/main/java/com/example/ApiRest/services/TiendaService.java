package com.example.ApiRest.services;
import com.example.ApiRest.models.TiendaModel;
import com.example.ApiRest.repositories.ITiendaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
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
    public Optional<TiendaModel> getById(Long id_tienda){
        return tiendaRepositorie.findById(id_tienda);
    }

    //Put (Update)
    public TiendaModel updateByIdTienda(TiendaModel request, Long id_tienda){
        TiendaModel tienda = tiendaRepositorie.findById(id_tienda).get();

        tienda.setNombreTienda(request.getNombreTienda());
        tienda.setCantidadPelicula(request.getCantidadPelicula());
        tienda.setCiudad(request.getCiudad());
        tienda.setDireccion(request.getDireccion());
        tienda.setNumeroEmpleados(request.getNumeroEmpleados());

        return  tiendaRepositorie.save(tienda);
    }

    //Delete
    public Boolean deleteTienda(Long id_tienda){
        try
        {
            tiendaRepositorie.deleteById(id_tienda);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
