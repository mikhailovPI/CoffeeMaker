package ru.mikhailov.coffeemaker.coffeemachine.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoffeeMachineDto {

    Long id;
//    Boolean powerOn;
    Coffee coffee;

//    public void turnOn() {
//        this.powerOn = true;
//        System.out.println("Кофеварка включена. Выбирайте тип кофе для приготовления!:)");
//    }
//
//    public void turnOff() {
//        this.powerOn = false;
//        System.out.println("Кофеварка выключена. Включите кофеварку и получайте удовольствие от кофе!:)");
//    }
}
