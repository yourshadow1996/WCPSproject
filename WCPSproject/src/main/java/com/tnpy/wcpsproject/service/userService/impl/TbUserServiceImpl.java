package com.tnpy.wcpsproject.service.userService.impl;

import com.tnpy.wcpsproject.mapper.mysql.TbUserMapper;
import com.tnpy.wcpsproject.model.mysql.TbUser;
import com.tnpy.wcpsproject.service.userService.ITbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl implements ITbUserService {

    @Autowired
    TbUserMapper tbuserMapper ;

    @Override
    public String selectByusername( String username) {

        return tbuserMapper.selectByusername(username);
    }

    //    @Override
//    public String selectByCarLicenceTime(String carLicence)
//    {
//        // TODO Auto-generated method stub
//        return tbLaissezPasserInfoMapper.selectByCarLicenceTime(carLicence);
//    }
    @Override
    public TbUser selectByPrimaryKey(String username) {
        // TODO Auto-generated method stub
        return tbuserMapper.selectByPrimaryKey(username);
    }
    @Override
    public int insert(TbUser tbuser) {
        // TODO Auto-generated method stub
        return tbuserMapper.insert(tbuser);
    }



}
