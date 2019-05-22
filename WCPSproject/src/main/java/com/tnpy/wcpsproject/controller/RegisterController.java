package com.tnpy.wcpsproject.controller;
import com.tnpy.common.Enum.StatusEnum;
import com.tnpy.common.utils.web.TNPYResponse;
import com.tnpy.wcpsproject.model.mysql.TbUser;
import com.tnpy.wcpsproject.service.userService.ITbUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.UUID;
//注册
@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Resource
    ITbUserService TbUserService;

    @RequestMapping(value = "/userregister")
    public TNPYResponse userRegister(String username,  String password ) {

        TNPYResponse response = new TNPYResponse();
        try
        {
            String has_username = TbUserService.selectByusername(username);
            if(has_username == null) {
                TbUser tbUser = new TbUser();
                tbUser.setUserid(UUID.randomUUID().toString());
                tbUser.setUsername(username);
                tbUser.setPassword(password);
                tbUser.setStadu(1);
                TbUserService.insert(tbUser);
                response.setStatus(StatusEnum.ResponseStatus.Success.getIndex());
                response.setMessage("用户注册成功");
            }else {
                response.setStatus(StatusEnum.ResponseStatus.Fail.getIndex());
                response.setMessage("该用户已存在 , 无需重新注册");
                return  response;
            }
            return  response;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            response.setMessage("登记注册失败,请联系管理员");
            return  response;
        }
    }
}
