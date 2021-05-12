package cn.mirage.supermarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sales")
public class Sales {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @Column(name = "time")
    private String time;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

    @Column(name = "purchase_price")
    private Float purchasePrice;

}
