package com.qf.videos.mapper;

import com.qf.videos.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin selectAdminByUsernameAndPassword(Admin admin);
}
