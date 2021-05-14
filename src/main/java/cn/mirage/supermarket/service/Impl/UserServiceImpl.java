package cn.mirage.supermarket.service.Impl;

import cn.mirage.supermarket.entity.User;
import cn.mirage.supermarket.repository.UserRepository;
import cn.mirage.supermarket.service.UserService;
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
}
