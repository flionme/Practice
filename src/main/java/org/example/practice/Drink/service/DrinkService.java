package org.example.practice.Drink.service;

import lombok.RequiredArgsConstructor;
import org.example.practice.Drink.model.Drink;
import org.example.practice.Drink.model.DrinkDto;
import org.example.practice.Drink.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DrinkService
{
    private final DrinkRepository drinkRepository;
    private final IngredientsRepository ingredientsRepository;
    
    public void register(DrinkDto.Register dto)
    {
        Drink drink = drinkRepository.save(dto.toEntity());
        
        for(IngredientsDto.Register newDto : dto.getIngredientsListss())
        {
            ingredientsRepository.save(newDto.toEntity(drink));
        }
        
    }
    
    public List<DrinkDto.drinkRes> list()
    {
        List<Drink>  result = drinkRepository.findAll();
        
        return result.stream().map(DrinkDto.drinkRes::from).toList();
    }
    
    public List<DrinkDto.drinkRes> search(String name)
    {
        List<Drink>  result = drinkRepository.findByName(name);
    
        return result.stream().map(DrinkDto.drinkRes::from).toList();
    }
    
    public DrinkDto.drinkRes read(Integer idx)
    {
        Optional<Drink> result = drinkRepository.findById(idx);
        if(!result.isEmpty())
        {
            Drink drink = result.get();
            
            return DrinkDto.drinkRes.from(drink);
        }
        return null;
    }
}
