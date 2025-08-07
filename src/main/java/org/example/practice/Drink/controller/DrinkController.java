package org.example.practice.Drink.controller;

import lombok.RequiredArgsConstructor;
import org.example.practice.Drink.model.DrinkDto;
import org.example.practice.Drink.service.DrinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drink")
public class DrinkController
{
    private final DrinkService drinkService;
    
    @PostMapping("/register")
    public ResponseEntity register(DrinkDto.Register dto)
    {
        drinkService.register(dto);
        return ResponseEntity.status(200).body("Success");
    }
    
    @GetMapping("/list")
    public ResponseEntity list()
    {
        List<DrinkDto.drinkRes> result =  drinkService.list();
        
        return ResponseEntity.status(200).body(result);
    }
    
    @GetMapping("/search")
    public ResponseEntity list(String name)
    {
        List<DrinkDto.drinkRes> result =  drinkService.search(name);
        
        return ResponseEntity.status(200).body(result);
    }
    
    @GetMapping("/read")
    public ResponseEntity read(Integer idx)
    {
        DrinkDto.drinkRes result = drinkService.read(idx);
        
        return ResponseEntity.status(200).body(result);
    }
    
}
