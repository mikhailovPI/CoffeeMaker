package ru.mikhailov.coffeemaker.coffeemachine.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoffeeMachineDto {

    Long id;

    String name;

    List<Coffee> coffee;

    //Boolean power;
}