package ru.mikhailov.coffeemaker.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "CoffeeMakerApplication",
                description = "Приложение для кофемашины",
                version = "1.0.0",
                contact = @Contact(
                        name = "Mikhailov Pavel"
                )
        )
)
public class OpenApiConfig {

}
