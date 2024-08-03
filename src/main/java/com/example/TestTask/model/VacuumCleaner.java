package com.example.TestTask.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vacuum_cleaners")
public class VacuumCleaner extends Models{

    private double dustBagVolume;
    private int numberOfModes;

    public VacuumCleaner() {
    }

    @Override
    public String getType() {
        return "VacuumCleaner";
    }
}
