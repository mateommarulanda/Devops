package com.example.ApiRest.services;
import com.example.ApiRest.models.PeliculaModel;
import com.example.ApiRest.models.TiendaModel;
import com.example.ApiRest.repositories.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    IPeliculaRepository peliculaRepository;

    //Get
    public ArrayList<PeliculaModel> getPelicula(){
        return (ArrayList<PeliculaModel>) peliculaRepository.findAll();
    }

    //Post
    public  PeliculaModel savePelicula(PeliculaModel pelicula){
        return peliculaRepository.save(pelicula);
    }

    //Get id
    public Optional<PeliculaModel> getById(Long id){
        return peliculaRepository.findById(id);
    }

    //Put (Update)
    public PeliculaModel updateById(PeliculaModel request, Long id){
        PeliculaModel pelicula = peliculaRepository.findById(id).get();

        pelicula.setNombre(request.getNombre());
        pelicula.setDescripcion(request.getDescripcion());
        pelicula.setFecha(request.getFecha());
        pelicula.setGenero(request.getGenero());
        pelicula.setValor(request.getValor());

        return  peliculaRepository.save(pelicula);
    }

    // Delete
    public Boolean deletePelicula(Long id){
        try
        {
            peliculaRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
