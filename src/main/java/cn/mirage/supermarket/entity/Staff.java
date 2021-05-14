package cn.mirage.supermarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "staff")
public class Staff {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Column(name = "salary")
    private String salary;

}
