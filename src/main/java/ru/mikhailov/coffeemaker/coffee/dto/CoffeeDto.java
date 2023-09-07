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
@Schema(description = "Сущность кофе")
public class CoffeeDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    Long id;

    @Schema(description = "Название типа кофе", example = "Моккачино")
    String name;

    @Schema(description = "Объем молока", example = "250,0")
    Double milkVolume;

    @Schema(description = "Объем кофе", example = "250,0")
    Double coffeeVolume;
}
