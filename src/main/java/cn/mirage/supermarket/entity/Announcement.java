package cn.mirage.supermarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "announcement")
public class Announcement {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private String time;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "content")
    private String content;

}
