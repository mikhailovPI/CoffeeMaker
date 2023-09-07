package ru.mikhailov.coffeemaker.coffeemake.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;
import ru.mikhailov.coffeemaker.coffeemachine.model.CoffeeMachine;

import javax.persistence.*;

import static ru.mikhailov.coffeemaker.coffeemake.model.CoffeeMake.SCHEMA_TABLE;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = CoffeeMake.COFFEE_MAKE, schema = SCHEMA_TABLE)
public class CoffeeMake {

    public static final String COFFEE_MAKE = "coffee_make";
    public static final String SCHEMA_TABLE = "public";
    public static final String COFFEE_MAKE_ID = "coffee_make_id";
    public static final String COFFEE_MACHINE_ID = "coffee_machine_id";
    public static final String COFFEE_ID =  "coffee_id";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COFFEE_MAKE_ID)
    Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = COFFEE_MACHINE_ID)
    CoffeeMachine coffeeMachine;

    @OneToOne(optional = false)
    @JoinColumn(name = COFFEE_ID)
    Coffee coffee;

    public CoffeeMake(CoffeeMachine coffeeMachine, Coffee coffee) {
        this.coffeeMachine = coffeeMachine;
        this.coffee = coffee;
    }
}
