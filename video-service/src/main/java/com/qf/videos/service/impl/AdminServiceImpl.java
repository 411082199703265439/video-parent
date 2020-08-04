package com.qf.videos.service.impl;

import com.qf.videos.mapper.AdminMapper;
import com.qf.videos.pojo.Admin;
import com.qf.videos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin selectAdminByUsernameAndPassword(Admin admin) {
        return adminMapper.selectAdminByUsernameAndPassword(admin);
    }
}
