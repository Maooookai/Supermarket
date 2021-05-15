package cn.mirage.supermarket.service;

import cn.mirage.supermarket.entity.User;
import cn.mirage.supermarket.to.PasswordDTO;

public interface UserService {

    User getUserById(long id);

    String modifyPassword(PasswordDTO dto);

}
