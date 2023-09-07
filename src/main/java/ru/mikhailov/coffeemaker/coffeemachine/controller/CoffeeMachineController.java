package ru.mikhailov.coffeemaker.coffeemachine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mikhailov.coffeemaker.coffeemachine.dto.CoffeeMachineDto;
import ru.mikhailov.coffeemaker.coffeemachine.service.CoffeeMachineService;
import ru.mikhailov.coffeemaker.exception.NotFoundException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = CoffeeMachineController.URL_COFFEEMACHINE)
public class CoffeeMachineController {

    public static final String URL_COFFEEMACHINE = "/coffeem/";

    private final CoffeeMachineService coffeeMachineService;
/*    private final ToggleService toggleService;

    @PostMapping(URL_COFFEEMACHINE + "/on")
    public void turnOn(Boolean powerOn) {
        log.info("PostMapping/Включение кофемашины/turnOn");
        toggleService.turnOn(powerOn);
    }

    @PostMapping(URL_COFFEEMACHINE + "/off")
    public void turnOff(Boolean powerOn) {
        log.info("PostMapping/Выключение кофемашины/turnOff");
        toggleService.turnOff(powerOn);
    }*/

/*    @PostMapping("/coffeemachine/make")
    public void makeCoffee(
            @RequestBody CoffeeMachineDto coffeeMachineDto
            *//*@RequestParam(name = "nameCoffee", required = false) String nameCoffee*//*) {
        //if (coffeeMachineDto.getPowerOn()) {
            coffeeMachineService.makeCoffee(coffeeMachineDto);
*//*        } else {
            throw new NotFoundException(
                    String.format("Кофеварка выключена. Включите кофеварку и получайте удовольствие от кофе!:)"));
        }*//*
    }*/

    @PostMapping(URL_COFFEEMACHINE + "/make")
    public void makeCoffee(
            @RequestBody CoffeeMachineDto coffeeMachineDto) {
        log.info("PostMapping/Приготовление кофе/makeCoffee");
        if (true) {
            coffeeMachineService.makeCoffee(coffeeMachineDto);
        } else {
            throw new NotFoundException(
                    String.format("Кофеварка выключена. Включите кофеварку и получайте удовольствие от кофе!:)"));
        }
    }
}