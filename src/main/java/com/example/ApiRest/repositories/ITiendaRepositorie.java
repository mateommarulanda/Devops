package com.example.ApiRest.repositories;
import com.example.ApiRest.models.TiendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiendaRepositorie extends JpaRepository<TiendaModel, Long> {
}
