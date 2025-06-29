package com.example.app.controller;

import com.example.app.entity.Carro;
import com.example.app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro){

        try {

        Carro carroSalvo = carroService.save(carro);
        return new ResponseEntity<>("Carro " + carroSalvo.getNome() + " salvo com sucesso", HttpStatus.OK); }
        catch (Exception e){
            return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        return new ResponseEntity<>(carroService.deleteById(id), HttpStatus.OK);
    }

}
