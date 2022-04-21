package com.peaksoft.spring_security.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "productId")
    private Long id;
    private String name;
    private String brand;
    private String madeIn;
    private double price;
}
