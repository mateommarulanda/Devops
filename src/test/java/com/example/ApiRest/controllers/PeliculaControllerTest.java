package com.example.ApiRest.controllers;
import com.example.ApiRest.controllers.PeliculaController;
import com.example.ApiRest.models.PeliculaModel;
import com.example.ApiRest.repositories.IPeliculaRepository;
import com.example.ApiRest.repositories.ITiendaRepositorie;
import com.example.ApiRest.services.PeliculaService;
import com.example.ApiRest.services.TiendaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaControllerTest {

    @InjectMocks
    private PeliculaController peliculaController;

    @Mock
    private PeliculaService peliculaService;

    @Mock
    private ITiendaRepositorie tiendaRepositorie;

    @Mock
    private IPeliculaRepository peliculaRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPelicula() {
        // Configuración del comportamiento simulado
        when(peliculaService.getPelicula()).thenReturn(new ArrayList<>());

        // Llamada al método del controlador y verificación del resultado
        ArrayList<PeliculaModel> result = peliculaController.getPelicula();
        assertNotNull(result);
        assertEquals(0, result.size());

        // Verificación de llamadas a métodos simulados
        verify(peliculaService, times(1)).getPelicula();
    }

    @Test
    public void testSavePelicula() {

        PeliculaModel pelicula = new PeliculaModel();
        when(peliculaService.savePelicula(any())).thenReturn(pelicula);


        PeliculaModel result = peliculaController.savePelicula(pelicula);
        assertNotNull(result);


        verify(peliculaService, times(1)).savePelicula(any());
    }

    @Test
    public void testGetPeliculaById() {

        Long id = 1L;
        when(peliculaService.getById(id)).thenReturn(Optional.of(new PeliculaModel()));


        Optional<PeliculaModel> result = peliculaController.getPeliculaById(id);
        assertTrue(result.isPresent());


        verify(peliculaService, times(1)).getById(id);
    }

    @Test
    public void testUpdatePeliculaById() {

        Long id = 1L;
        PeliculaModel pelicula = new PeliculaModel();
        when(peliculaService.updateById(any(), eq(id))).thenReturn(pelicula);


        PeliculaModel result = peliculaController.updatePeliculaById(pelicula, id);
        assertNotNull(result);


        verify(peliculaService, times(1)).updateById(any(), eq(id));
    }

    @Test
    public void testDeleteById() {

        Long id = 1L;
        when(peliculaService.deletePelicula(id)).thenReturn(true);


        String result = peliculaController.deleteById(id);
        assertTrue(result.contains("elimino"));


        verify(peliculaService, times(1)).deletePelicula(id);
    }

}