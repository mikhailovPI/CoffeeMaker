package ru.mikhailov.coffeemaker.coffee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.coffeemaker.coffee.dto.CoffeeDto;
import ru.mikhailov.coffeemaker.coffee.dto.CoffeeUpdateDto;
import ru.mikhailov.coffeemaker.coffee.service.CoffeeService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = CoffeeController.URL_COFFEE)
@Tag(name = "CoffeeController", description = "Позволяет работать с типами кофе")
public class CoffeeController {

    public static final String URL_COFFEE = "/coffee";
    private final CoffeeService coffeeService;

    @GetMapping
    @Operation(
            summary = "Получение всех типов кофе",
            description = "Позволяет получить все типы кофе из базы данных")
    public List<CoffeeDto> getAllCoffee(
            @RequestParam(name = "from", defaultValue = "0") @Parameter(description = "Номер страницы") int from,
            @RequestParam(name = "size", defaultValue = "5")
            @Parameter(description = "Количество объектов на странице") int size) {
        log.info("GetMapping/Получение всех типов кофе/getAllCoffee");
        return coffeeService.getAllCoffee(from, size);
    }

    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Получение типа кофе",
            description = "Позволяет получить тип кофе по идентификатору")
    public CoffeeDto getCoffeeById(
            @PathVariable @Parameter(description = "Идентификатор типа кофе") Long id) {
        log.info("GetMapping/Получение типа кофе по id/getCoffeeById");
        return coffeeService.getCoffeeById(id);
    }

    @GetMapping(path = "/name")
    @Operation(
            summary = "Поиск типа кофе",
            description = "Позволяет осуществить поиск типа кофе по названию")
    public List<CoffeeDto> searchCoffeeByName(
            @RequestParam(name = "nameCoffee", required = false)
            @Parameter(description = "Название/часть названия типа кофе") String nameCoffee,
            @RequestParam(name = "from", defaultValue = "0") @Parameter(description = "Номер страницы") int from,
            @RequestParam(name = "size", defaultValue = "5")
            @Parameter(description = "Количество объектов на странице") int size) {
        log.info("GetMapping/Поиск типа кофе по названию/searchCoffeeByName");
        return coffeeService.searchCoffeeByName(nameCoffee, from, size);
    }

    @PostMapping
    @Operation(
            summary = "Создание типа кофе",
            description = "Позволяет создать новый тип кофе")
    public CoffeeDto createCoffee(@RequestBody @Parameter(description = "Объект типа кофе") CoffeeDto coffeeDto) {
        log.info("PostMapping/Создание нового типа кофе/createCoffee");
        return coffeeService.createCoffee(coffeeDto);
    }

    @PatchMapping(path = "/{id}")
    @Operation(
            summary = "Обновление типа кофе",
            description = "Позволяет обновить существующий тип кофе")
    public CoffeeDto patchCoffee(
            @PathVariable @Parameter(description = "Идентификатор типа кофе") Long id,
            @RequestBody @Parameter(description = "Обновленный тип кофе") CoffeeUpdateDto coffee) {
        log.info("PatchMapping/Обновление существующего типа кофе/patchCoffee");
        return coffeeService.patchCoffee(id, coffee);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(
            summary = "Удаление типа кофе",
            description = "Позволяет удалить тип кофе по идентификатору")
    public void deleteCoffeeById(@PathVariable @Parameter(description = "Идентификатор типа кофе") Long id) {
        log.info("DeleteMapping/Удаление типа кофе по id/deleteCoffeeById");
        coffeeService.deleteCoffeeById(id);
    }
}
