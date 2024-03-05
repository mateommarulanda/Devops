package com.example.ApiRest.repositories;
import com.example.ApiRest.models.PeliculaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepository extends JpaRepository<PeliculaModel, Long> {
}
