package ru.mikhailov.coffeemaker.coffeemachine.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.mikhailov.coffeemaker.coffee.model.Coffee;

import javax.persistence.*;

import java.util.List;

import static ru.mikhailov.coffeemaker.coffee.model.Coffee.COFFEE_ID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = CoffeeMachine.TABLE_COFFEEMACHINE, schema = Coffee.SCHEMA_TABLE)
public class CoffeeMachine {

    public static final String TABLE_COFFEEMACHINE = "coffeemacine";
    public static final String SCHEMA_TABLE = "public";
    public static final String COFFEEMACHINE_ID = "coffeemachine_id";
    public static final String COFFEEMACHINE_NAME = "coffeemachine_name";
    public static final String COFFEEMACHINE_POWER = "power";

/*    public CoffeeMachine(Coffee coffee) {
        this.coffee = coffee;
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COFFEEMACHINE_ID)
    Long id;

    @Column(name = COFFEEMACHINE_NAME)
    String name;

    @OneToMany
    @JoinColumn(name = COFFEE_ID)
    List<Coffee> coffee;

    @Column(name = COFFEEMACHINE_POWER)
    Boolean power;

}