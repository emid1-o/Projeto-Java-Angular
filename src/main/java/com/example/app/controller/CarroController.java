package com.example.app.controller;

import com.example.app.entity.Carro;
import com.example.app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/todos")
    public ResponseEntity<List<Carro>> verCarros(){

        try {

            return new ResponseEntity<>(carroService.verCarros(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }


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
        try {
            return new ResponseEntity<>(carroService.deleteById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editById(@PathVariable Long id, @RequestBody Carro carro){

        try {
            return new ResponseEntity<>(carroService.editById(id, carro), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(carroService.editById(id, carro), HttpStatus.BAD_REQUEST);
        }
    }

}
