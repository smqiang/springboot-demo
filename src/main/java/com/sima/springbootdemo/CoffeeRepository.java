package com.sima.springbootdemo;

import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository  extends CrudRepository<Coffee, String> {
}
