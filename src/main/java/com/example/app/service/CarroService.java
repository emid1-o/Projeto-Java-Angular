package com.example.app.service;

import com.example.app.entity.Carro;
import com.example.app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro findById(Long id){

        return carroRepository.findById(id).orElse(null);

    }


    public List<Carro> verCarros(){

        return carroRepository.findAll();
    }

    public String save(Carro carro){

        carroRepository.save(carro);
        return "Carro de id " + carro.getId() + " salvo com sucesso";
    }

    public String deleteById(Long id){

        carroRepository.deleteById(id);
        return "Carro de id " + id + " deletado com sucesso.";
    }

    public String update(Long id, Carro carro){

        carro.setId(id);
        this.carroRepository.save(carro);
        return "Carro foi atualizado com sucesso";
    }


}
