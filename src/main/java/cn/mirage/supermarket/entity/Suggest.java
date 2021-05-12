package cn.mirage.supermarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "suggest")
public class Suggest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "reply_user")
    private Long replyUser;

    @Column(name = "reply_time")
    private String replyTime;

    @Column(name = "reply")
    private String reply;

    @Column(name = "time")
    private String time;

}
