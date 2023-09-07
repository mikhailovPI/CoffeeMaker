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
@Table(name = CoffeeMachine.TABLE_COFFEE_MACHINE, schema = Coffee.SCHEMA_TABLE)
public class CoffeeMachine {

    public static final String TABLE_COFFEE_MACHINE = "coffee_machine";
    public static final String SCHEMA_TABLE = "public";
    public static final String COFFEE_MACHINE_ID = "coffee_machine_id";
    public static final String COFFEE_MACHINE_NAME = "coffee_machine_name";
    public static final String COFFEE_MACHINE_POWER = "power";
    public static final String COFFEE_MAKE = "coffee_make";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COFFEE_MACHINE_ID)
    Long id;

    @Column(name = COFFEE_MACHINE_NAME)
    String name;

    @Column(name = COFFEE_MACHINE_POWER)
    Boolean power;

//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinTable(name = COFFEE_MAKE,
//            joinColumns = @JoinColumn(name = COFFEE_MACHINE_ID),
//            inverseJoinColumns = @JoinColumn(name = COFFEE_ID))
    @OneToMany
    @JoinColumn(name = COFFEE_ID)
    List<Coffee> coffee;
}