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
    @GetMapping(path = "/{id_tienda}")
    public Optional<TiendaModel> getPeliculaById(@PathVariable("id_tienda") Long id_tienda){
        return this.tiendaService.getById(id_tienda);
    }

    //Put (Update)
    @PatchMapping(path = "/{id_tienda}")
    public TiendaModel updateTiendaById(@RequestBody TiendaModel request,@PathVariable("id_tienda") Long id_tienda){
        return this.tiendaService.updateByIdTienda(request, id_tienda);
    }

    // Delete
    @DeleteMapping(path = "/{id_tienda}")
    public String deleteById(@PathVariable("id_tienda") Long id_tienda){
        boolean ok = this.tiendaService.deleteTienda(id_tienda);

        if(ok)
        {
            return "Tienda con el id:" + id_tienda + " se elimino";
        }
        else
        {
            return "Error, la tienda con el id:" + id_tienda + " no se pudo eliminar";
        }
    }
}
