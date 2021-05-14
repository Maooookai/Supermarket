package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.User;
import cn.mirage.supermarket.repository.UserRepository;
import cn.mirage.supermarket.service.LoginService;
import cn.mirage.supermarket.to.LoginDTO;
import cn.mirage.supermarket.to.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginVO login(LoginDTO dto) {
        LoginVO loginVO = new LoginVO();
        if (dto.getId().isEmpty()) {
            loginVO.setSuccess(false);
            return loginVO;
        }
        if (!userRepository.findById(Long.valueOf(dto.getId())).isPresent()) {
            loginVO.setSuccess(false);
            loginVO.setMessage("该用户不存在！");
        } else {
            User user = userRepository.findById(Long.valueOf(dto.getId())).get();
            if (user.getPassword().equals(dto.getPassword())) {
                loginVO.setSuccess(true);
            } else {
                loginVO.setSuccess(false);
                loginVO.setMessage("用户名或密码错误！");
            }
        }
        return loginVO;
    }
}
