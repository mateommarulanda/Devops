package com.example.ApiRest.controllers;
import com.example.ApiRest.models.PeliculaModel;
import com.example.ApiRest.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    //Get
    @GetMapping
    public ArrayList<PeliculaModel> getPelicula(){
        return this.peliculaService.getPelicula();
    }

    //Post
    //@PostMapping("/agregar")
    @PostMapping
    public PeliculaModel savePelicula(@RequestBody PeliculaModel pelicula){
        return this.peliculaService.savePelicula(pelicula);
    }

    //Get id
    @GetMapping(path = "/{id}")
    public Optional<PeliculaModel> getPeliculaById(@PathVariable("id") Long id){
        return this.peliculaService.getById(id);
    }

    //Put (Update)
    @PatchMapping(path = "/{id}")
    public PeliculaModel updatePeliculaById(@RequestBody PeliculaModel request,@PathVariable("id") Long id){
        return this.peliculaService.updateById(request, id);
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
            return "Error, la pelicula con el id:" + id + " no se pudo eliminar";
        }
    }

}
