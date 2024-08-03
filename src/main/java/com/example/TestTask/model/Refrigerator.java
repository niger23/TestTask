package com.example.TestTask.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "refrigerators")
public class Refrigerator extends Models{

    private int numberOfDoors;
    private String compressorType;

    public Refrigerator() {
    }

    @Override
    public String getType() {
        return "Refrigerator";
    }
}
