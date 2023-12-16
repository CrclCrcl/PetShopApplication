package com.example.Ocochodzi.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description")
    @NotBlank(message = "Product's description must be not null")
    private String description;
    /*@NotBlank(message = "Product's name must be not null")*/
    @Column(name="Name")
    private String name;

    @Column(name="Current_Value")
    private int currentvalue;

    @Column(name = "Accessibility")
    private Boolean accessibility ;

    Products(){

    }
    public Boolean getAvailable() {
        return accessibility;
    }

    void setAvailable(final Boolean available) {
        this.accessibility = available;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }


}
