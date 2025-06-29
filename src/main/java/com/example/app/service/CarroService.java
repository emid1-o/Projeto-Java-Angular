package com.example.app.service;

import com.example.app.entity.Carro;
import com.example.app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro save(Carro carro){

        carroRepository.save(carro);
        return carro;
    }

    public String deleteById(Long id){

        if (carroRepository.existsById(id)){
            carroRepository.deleteById(id);
            return "Carro de id " + id + " deletado com sucesso.";
        }
        return "Não há um carro com id " + id + " registrado no banco";
    }


}
