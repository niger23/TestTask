package com.example.TestTask.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tvs")
public class TV extends Models{

    private String category;
    private String technology;

    public TV() {
    }

    @Override
    public String getType() {
        return "TV";
    }
}