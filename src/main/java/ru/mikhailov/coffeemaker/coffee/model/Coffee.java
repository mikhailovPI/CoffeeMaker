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
@Table (name = Coffee.TABLE_COFFEE, schema = Coffee.SCHEMA_TABLE)
public class Coffee {

    public static final String TABLE_COFFEE= "coffee";
    public static final String SCHEMA_TABLE = "public";
    public static final String COFFEE_ID = "coffee_id";
    public static final String ROLE_NAME = "coffee_name";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COFFEE_ID)
    Long id;

    @Column(name = ROLE_NAME)
    String name;
}
