package com.example.TestTask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import javax.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PC.class, name = "PC"),
        @JsonSubTypes.Type(value = Devices.class, name = "Devices"),
        @JsonSubTypes.Type(value = Refrigerator.class, name = "Refrigerator"),
        @JsonSubTypes.Type(value = Smartphone.class, name = "Smartphone"),
        @JsonSubTypes.Type(value = TV.class, name = "TV"),
        @JsonSubTypes.Type(value = VacuumCleaner.class, name = "VacuumCleaner"),
})
@Data
@Entity
@Table(name = "models")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private double price;
    private boolean available;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deviceId")
    @JsonBackReference
    private Devices devices;

    public abstract String getType();
}
