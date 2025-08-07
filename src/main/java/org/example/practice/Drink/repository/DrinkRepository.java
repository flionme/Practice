package org.example.practice.Drink.repository;

import org.example.practice.Drink.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Integer>
{
    List<Drink> findByName(String name);
}
