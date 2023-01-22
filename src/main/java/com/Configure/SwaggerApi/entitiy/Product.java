package com.Configure.SwaggerApi.entitiy;


import lombok.Data;
import javax.persistence.*;

@Entity(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;
}
