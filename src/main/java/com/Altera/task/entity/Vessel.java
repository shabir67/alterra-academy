package com.Altera.task.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "vessels")
@Data
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String vessel_id;

    @Column(nullable = false, length = 100)
    private String vessel_class;
}
