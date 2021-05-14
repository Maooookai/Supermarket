package cn.mirage.supermarket.service;

import cn.mirage.supermarket.to.LoginDTO;
import cn.mirage.supermarket.to.LoginVO;

public interface LoginService {

    LoginVO login(LoginDTO dto);

}
