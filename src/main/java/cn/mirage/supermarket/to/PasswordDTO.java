package cn.mirage.supermarket.to;

import cn.mirage.supermarket.entity.User;
import lombok.Data;

@Data
public class PasswordDTO {

    private User user;

    private PasswordVO vo;

}
