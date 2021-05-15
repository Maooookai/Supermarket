package cn.mirage.supermarket.to;

import lombok.Data;

@Data
public class PasswordVO {

    private String oldPassword;

    private String newPassword;

    private String newPasswordCheck;

}
