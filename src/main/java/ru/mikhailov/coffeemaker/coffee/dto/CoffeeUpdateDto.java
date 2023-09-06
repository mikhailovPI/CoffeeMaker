package ru.mikhailov.coffeemaker.coffee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Сущность типа кофе для обновление")
public class CoffeeUpdateDto {

    @Schema(description = "Название типа кофе", example = "Капучино")
    String name;
}
