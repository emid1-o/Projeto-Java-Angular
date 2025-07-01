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

    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro> getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(carroService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Carro>> findAll(){

        try {

            return new ResponseEntity<>(carroService.verCarros(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro){

        try {

        String mensagem = carroService.save(carro);
        return new ResponseEntity<>(mensagem, HttpStatus.CREATED); }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(carroService.deleteById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Carro carro){

        try {
            return new ResponseEntity<>(carroService.update(id, carro), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome){

        try {
            return new ResponseEntity<>(carroService.findByNome(nome), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam Long id){

        try {
            List<Carro> carro = this.carroService.findByMarca(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAcimaAno")
    public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam int ano){

        try {
            List<Carro> carros = this.carroService.findAcimaAno(ano);
            return new ResponseEntity<>(carros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



}
