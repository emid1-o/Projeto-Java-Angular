package com.example.app.repository;

import com.example.app.entity.Carro;
import com.example.app.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    public List<Carro> findByNome(String nome);

    public List<Carro> findByMarca(Marca marca);

    @Query("FROM Carro c WHERE c.ano > :ano")
    public List<Carro> findAcimaAno(int ano);
}
