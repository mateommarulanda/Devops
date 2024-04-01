package com.example.ApiRest.controllers;
import com.example.ApiRest.models.PeliculaModel;
import com.example.ApiRest.models.TiendaModel;
import com.example.ApiRest.repositories.IPeliculaRepository;
import com.example.ApiRest.repositories.ITiendaRepositorie;
import com.example.ApiRest.services.PeliculaService;
import com.example.ApiRest.services.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private ITiendaRepositorie tiendaRepositorie;
    @Autowired
    private IPeliculaRepository peliculaRepository;

    //Get
    @GetMapping
    public ArrayList<PeliculaModel> getPelicula(){
        return this.peliculaService.getPelicula();
    }

    //Post
    @PostMapping
    public PeliculaModel savePelicula(@RequestBody PeliculaModel pelicula){
        return this.peliculaService.savePelicula(pelicula);
    }

    @PostMapping(path = "/{id}/{id_tienda}")
    public String savePeliculaAndTeinda(@PathVariable long id, @PathVariable long id_tienda) {
        PeliculaModel pelicula = peliculaRepository.findById(id).orElse(null);
        TiendaModel tienda = tiendaRepositorie.findById(id_tienda).orElse(null);

        if (pelicula != null && tienda != null) {
            tienda.getPelicula().add(pelicula);
            tiendaRepositorie.save(tienda);
            peliculaRepository.save(pelicula);
            return "Pelicula asociada a la tienda de venta";
        } else {
            return "Error al asociar la película a la tienda. Película o tienda no encontrada.";
        }
    }

    //Get id
    @GetMapping(path = "/{id}")
    public Optional<PeliculaModel> getPeliculaById(@PathVariable("id") Long id){
        return this.peliculaService.getById(id);
    }

    //Put (Update)
    @PutMapping(path = "/{id}")
    public PeliculaModel updatePeliculaById(@RequestBody PeliculaModel pelicula,@PathVariable("id") long id){
        return this.peliculaService.updateById(pelicula, id);
    }

    // Delete
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.peliculaService.deletePelicula(id);

        if(ok)
        {
            return "Pelicula con el id:" + id + " se elimino";
        }
        else
        {
            return "Error, la pelicula con el id:" + id + " no se pudo eliminar nada";
        }
    }

}
