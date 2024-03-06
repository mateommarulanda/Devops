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
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;
    @Autowired
    private ITiendaRepositorie tiendaRepositorie;
    @Autowired
    private IPeliculaRepository peliculaRepository;

    @GetMapping
    public ArrayList<TiendaModel> getTienda(){
        return this.tiendaService.getTienda();
    }

    //Post
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
    @PutMapping(path = "/{id_tienda}")
    public TiendaModel updateTiendaById(@RequestBody TiendaModel tienda,@PathVariable("id_tienda") long id_tienda){
        return this.tiendaService.updateByIdTienda(tienda, id_tienda);
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
