package com.example.TestTask.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = PC.class, name = "PC")
//})
@Table(name = "personal_computers")
public class PC extends Models{

    private String category;
    private String processorType;

    public PC() {
    }
    @Override
    public String getType() {
        return "PC";
    }
}
