package com.example.TestTask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = TV.class, name = "TV"),
//        @JsonSubTypes.Type(value = PC.class, name = "PC"),
//        @JsonSubTypes.Type(value = Refrigerator.class, name = "Refrigerator"),
//        @JsonSubTypes.Type(value = Smartphone.class, name = "Smartphone"),
//        @JsonSubTypes.Type(value = VacuumCleaner.class, name = "VacuumCleaner")
//})
@Data
@Entity
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String company;
    private boolean onlineOrder;
    private boolean instalment;
    @OneToMany(mappedBy = "devices", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("devices")
    private List<Models> models;
}
