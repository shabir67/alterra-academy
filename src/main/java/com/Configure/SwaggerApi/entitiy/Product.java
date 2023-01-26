package com.Configure.SwaggerApi.entitiy;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Long price;


//    public Product(Long id, String name, String description, Integer stock, Long price) {
//        this.id = id;
//        this.name = name;
//        this.description =description;
//        this.stock = stock;
//        this.price = price;
}
