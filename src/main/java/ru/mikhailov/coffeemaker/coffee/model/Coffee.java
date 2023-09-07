package ru.mikhailov.coffeemaker.coffee.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = Coffee.TABLE_COFFEE, schema = Coffee.SCHEMA_TABLE)
public class Coffee {

    public static final String TABLE_COFFEE = "coffee";
    public static final String SCHEMA_TABLE = "public";
    public static final String COFFEE_ID = "coffee_id";
    public static final String COFFEE_NAME = "coffee_name";
    public static final String COFFEE_MILK = "milk_volume";
    public static final String COFFEE_VOLUME = "coffee_volume";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COFFEE_ID)
    Long id;

    @Column(name = COFFEE_NAME)
    String name;

    @Column(name = COFFEE_MILK)
    Double milkVolume;

    @Column(name = COFFEE_VOLUME)
    Double coffeeVolume;
}
