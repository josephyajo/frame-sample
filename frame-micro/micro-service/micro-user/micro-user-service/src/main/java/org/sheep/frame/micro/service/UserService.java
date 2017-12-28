package org.sheep.frame.micro.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.sheep.frame.micro.api.IUserService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: YangJiong
 * @Date: 17:44 2017/12/28
 */
@Component
@Service(interfaceClass = IUserService.class)
public class UserService implements IUserService {
    @Override
    public String getUser() {
        return "aaa";
    }
}
