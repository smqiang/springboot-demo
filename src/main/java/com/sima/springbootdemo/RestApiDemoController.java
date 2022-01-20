package com.sima.springbootdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
    private final CoffeeRepository repository;

    public RestApiDemoController(CoffeeRepository repository) {
        this.repository = repository;

        this.repository.saveAll(List.of(
                new Coffee("Cafe Cereza"),      // 樱桃
                new Coffee("Cafe Ganador"),     // 加纳多
                new Coffee("Cafe Lareno"),      //
                new Coffee("Cafe Tres Pontas")
        ));
    }

    @GetMapping
    Iterable<Coffee> getCoffees(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        return this.repository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
        return this.repository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        return this.repository.existsById(id) ?
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        this.repository.deleteById(id);
    }
}
