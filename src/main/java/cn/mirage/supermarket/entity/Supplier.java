package cn.mirage.supermarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
