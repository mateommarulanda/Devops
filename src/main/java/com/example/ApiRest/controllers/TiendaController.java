package com.example.ApiRest.controllers;
import com.example.ApiRest.models.PeliculaModel;
import com.example.ApiRest.models.TiendaModel;
import com.example.ApiRest.services.PeliculaService;
import com.example.ApiRest.services.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @GetMapping
    public ArrayList<TiendaModel> getTienda(){
        return this.tiendaService.getTienda();
    }

    //Post
    //@PostMapping("/agregar")
    @PostMapping
    public TiendaModel saveTienda(@RequestBody TiendaModel tienda){
        return this.tiendaService.saveTienda(tienda);
    }

    //Get id
    @GetMapping(path = "/{id}")
    public Optional<TiendaModel> getPeliculaById(@PathVariable("id") Long id){
        return this.tiendaService.getById(id);
    }

    //Put (Update)
    @PatchMapping(path = "/{id}")
    public TiendaModel updateTiendaById(@RequestBody TiendaModel request,@PathVariable("id") Long id){
        return this.tiendaService.updateByIdTienda(request, id);
    }

    // Delete
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.tiendaService.deleteTienda(id);

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
