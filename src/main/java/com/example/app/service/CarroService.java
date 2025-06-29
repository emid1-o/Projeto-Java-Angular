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


    public List<Carro> verCarros(){

        return carroRepository.findAll();
    }

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

    public String editById(Long id, Carro carro){

        Carro carroExistente = carroRepository.findById(id).orElse(null);

        if (carroExistente != null){
            carroExistente.setNome(carro.getNome());
            carroExistente.setAno(carro.getAno());
            carroRepository.save(carroExistente);
            return "Carro de id " + id + " alterado com sucesso";
        } return "Carro de id " + id + " não encontrado";
    }


}
