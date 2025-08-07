package org.example.practice.Drink.model;

import lombok.Builder;
import lombok.Getter;

public class DrinkDto
{
    @Getter
    public static class Register
    {
        private String name;
        private Integer price;
        private String manufacturer;
        private List<IngredientsDto.Register> ingredientsListss;
        
        
        public Drink toEntity()
        {
            Drink entity = Drink.builder()
                    .name(name)
                    .price(price)
                    .manufacturer(manufacturer)
                    .build();
            return entity;
        }
    }
    
    @Getter
    @Builder
    public static class drinkRes
    {
        private Integer idx;
        private String name;
        private Integer price;
        private String manufacturer;
        private List<Ingredients.IngredientsRes> ingredientsLists;
        
        public static DrinkDto.drinkRes from(Drink entity)
        {
            DrinkDto.drinkRes dto = drinkRes.builder()
                    .idx(entity.getIdx())
                    .name(entity.getName())
                    .price(entity.getPrice())
                    .manufacturer(entity.getManufacturer())
                    .ingredientsLists(entity.getIngredientsList().stream().map(IngredientsDto.IngredientsRes::from).toList())
                    .build();
            return dto;
        }
    }
}
