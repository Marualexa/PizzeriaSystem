package com.example.pizzarest.persistence.repository;

import com.example.pizzarest.persistence.entity.PizzaEntity;
import com.example.pizzarest.service.dto.UpdatePizzaPriceDto;
import jdk.jfr.Description;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    Optional<PizzaEntity> findFirsByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
    int countByVeganTrue();

    @Query(value =
                "UPDATE pizza " +
                "SET price = :#{#newPizzaPrice.newPrice} " +
                "WHERE id_pizza = :#{#newPizzaPrice.pizzaId} ", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);
}
