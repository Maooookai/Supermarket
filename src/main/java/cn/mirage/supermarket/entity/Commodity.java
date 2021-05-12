package cn.mirage.supermarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "commodity")
public class Commodity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @Column(name = "purchase_price")
    private Float purchasePrice;

    @Column(name = "first_purchase_time")
    private String firstPurchaseTime;

    @Column(name = "price")
    private Float price;

    @Column(name = "stock")
    private Integer stock;

}
