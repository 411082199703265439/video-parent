package com.qf.videos.service;

import com.qf.videos.pojo.Admin;

public interface AdminService {
    Admin selectAdminByUsernameAndPassword(Admin admin);
}
