package ru.mikhailov.coffeemaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeDto {

    Long id;

    String name;
}