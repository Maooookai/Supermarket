package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.User;
import cn.mirage.supermarket.repository.UserRepository;
import cn.mirage.supermarket.service.UserService;
import cn.mirage.supermarket.to.PasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return new User();
    }

    @Override
    public String modifyPassword(PasswordDTO dto) {
        User user = dto.getUser();
        if (!dto.getVo().getNewPassword().equals(dto.getVo().getNewPasswordCheck()))
            return "两次输入密码不一致！";
        else {
            if (user.getPassword().equals(dto.getVo().getOldPassword())) {
                if (dto.getVo().getOldPassword().equals(dto.getVo().getNewPassword()))
                    return "新密码不能与旧密码相同！";
                user.setPassword(dto.getVo().getNewPassword());
                userRepository.save(user);
                return "密码修改成功！";
            } else
                return "原密码不正确！";
        }
    }
}
