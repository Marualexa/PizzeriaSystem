package com.example.pizzarest.persistence.repository;

import com.example.pizzarest.persistence.entity.PizzaEntity;
import jdk.jfr.Description;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    Optional<PizzaEntity> findFirsByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
    int countByVeganTrue();
}
