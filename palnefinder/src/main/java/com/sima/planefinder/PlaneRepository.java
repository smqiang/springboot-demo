package com.sima.planefinder;

import org.springframework.data.repository.CrudRepository;

public interface PlaneRepository extends CrudRepository<Aircraft, Long> {
}
