package com.example.TestTask.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "smartphones")
public class Smartphone extends Models{

    private int memory;
    private int numberOfCameras;

    public Smartphone() {
    }

    @Override
    public String getType() {
        return "Smartphone";
    }
}
