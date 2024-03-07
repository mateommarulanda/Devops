package com.example.ApiRest.controllers;
import com.example.ApiRest.controllers.TiendaController;
import com.example.ApiRest.models.TiendaModel;
import com.example.ApiRest.services.TiendaService;
import com.example.ApiRest.repositories.ITiendaRepositorie;
import com.example.ApiRest.repositories.IPeliculaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TiendaControllerTest {

    @InjectMocks
    private TiendaController tiendaController;

    @Mock
    private TiendaService tiendaService;

    @Mock
    private ITiendaRepositorie tiendaRepositorie;

    @Mock
    private IPeliculaRepository peliculaRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTienda() {
        // Configuración del comportamiento simulado
        when(tiendaService.getTienda()).thenReturn(new ArrayList<>());

        // Llamada al método del controlador y verificación del resultado
        ArrayList<TiendaModel> result = tiendaController.getTienda();
        assertNotNull(result);
        assertEquals(0, result.size());

        // Verificación de llamadas a métodos simulados
        verify(tiendaService, times(1)).getTienda();
    }

    @Test
    public void testSaveTienda() {
        // Configuración del comportamiento simulado
        TiendaModel tienda = new TiendaModel();
        when(tiendaService.saveTienda(any())).thenReturn(tienda);

        // Llamada al método del controlador y verificación del resultado
        TiendaModel result = tiendaController.saveTienda(tienda);
        assertNotNull(result);

        // Verificación de llamadas a métodos simulados
        verify(tiendaService, times(1)).saveTienda(any());
    }

    @Test
    public void testGetTiendaById() {
        // Configuración del comportamiento simulado
        Long id_tienda = 1L;
        when(tiendaService.getById(id_tienda)).thenReturn(Optional.of(new TiendaModel()));

        // Llamada al método del controlador y verificación del resultado
        Optional<TiendaModel> result = tiendaController.getPeliculaById(id_tienda);
        assertTrue(result.isPresent());

        // Verificación de llamadas a métodos simulados
        verify(tiendaService, times(1)).getById(id_tienda);
    }

    @Test
    public void testUpdateTiendaById() {
        // Configuración del comportamiento simulado
        Long id_tienda = 1L;
        TiendaModel tienda = new TiendaModel();
        when(tiendaService.updateByIdTienda(any(), eq(id_tienda))).thenReturn(tienda);

        // Llamada al método del controlador y verificación del resultado
        TiendaModel result = tiendaController.updateTiendaById(tienda, id_tienda);
        assertNotNull(result);

        // Verificación de llamadas a métodos simulados
        verify(tiendaService, times(1)).updateByIdTienda(any(), eq(id_tienda));
    }

    @Test
    public void testDeleteTiendaById() {
        // Configuración del comportamiento simulado
        Long id_tienda = 1L;
        when(tiendaService.deleteTienda(id_tienda)).thenReturn(true);

        // Llamada al método del controlador y verificación del resultado
        String result = tiendaController.deleteById(id_tienda);
        assertTrue(result.contains("elimino"));

        // Verificación de llamadas a métodos simulados
        verify(tiendaService, times(1)).deleteTienda(id_tienda);
    }
}
