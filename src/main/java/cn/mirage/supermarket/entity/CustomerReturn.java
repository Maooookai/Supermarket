package cn.mirage.supermarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_return")
public class CustomerReturn {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @Column(name = "purchase_time")
    private String purchaseTime;

    @Column(name = "return_time")
    private String returnTime;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

}
