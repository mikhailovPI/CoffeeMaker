package ru.mikhailov.coffeemaker.coffeemake.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.coffeemaker.coffeemake.service.CoffeeMakeService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = CoffeeMakeController.URL_COFFEE_MAKE)
@Tag(name = "CoffeeMakeController", description = "Позволяет создавать кофейные напитки")
public class CoffeeMakeController {

    public static final String URL_COFFEE_MAKE = "/coffee_make";

    private final CoffeeMakeService coffeeMakeService;

    @PostMapping( path = "/{coffeeMachineId}/make/{coffeeId}")
    @Operation(
            summary = "Получение кофейного напитка",
            description = "Позволяет получить кофейный напиток на созданной кофемашине")
    public void makeCoffee(
            @PathVariable Long coffeeMachineId,
            @PathVariable Long coffeeId) {
        log.info("PostMapping/Приготовление кофе/makeCoffee");
            coffeeMakeService.makeCoffee(coffeeMachineId, coffeeId);
    }
}