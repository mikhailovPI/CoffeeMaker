package ru.mikhailov.coffeemaker.coffeemachine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.coffeemaker.coffeemachine.dto.CoffeeMachineDto;
import ru.mikhailov.coffeemaker.coffeemachine.service.CoffeeMachineService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = CoffeeMachineController.URL_COFFEE_MACHINE)
@Tag(name = "CoffeeMachineController", description = "Позволяет создавать кофемашины")
public class CoffeeMachineController {

    public static final String URL_COFFEE_MACHINE = "/coffee_machine";

    private final CoffeeMachineService coffeeMachineService;

    @PatchMapping(path = "/{id}/on")
    @Operation(
            summary = "Включение кофемашины",
            description = "Позволяет включить кофемашину")
    public void turnOn(@PathVariable Long id) {
        log.info("PostMapping/Включение кофемашины/turnOn");
        coffeeMachineService.turnOn(id);
    }

    @PatchMapping(path = "/{id}/off")
    @Operation(
            summary = "Выключение кофемашины",
            description = "Позволяет выключить кофемашину")
    public void turnOff(@PathVariable Long id) {
        log.info("PostMapping/Выключение кофемашины/turnOff");
        coffeeMachineService.turnOff(id);
    }

    @PostMapping
    @Operation(
            summary = "Создание кофемашины",
            description = "Позволяет создать новую кофемашину")
    public CoffeeMachineDto createMachine(@RequestBody CoffeeMachineDto coffeeMachineDto) {
        log.info("PostMapping/Создание кофемашины/createCoffeeMachine");
        return coffeeMachineService.createCoffeeMachine(coffeeMachineDto);
    }
}