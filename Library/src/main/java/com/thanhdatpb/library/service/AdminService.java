package com.thanhdatpb.library.service;


import com.thanhdatpb.library.dto.AdminDto;
import com.thanhdatpb.library.model.Admin;

public interface AdminService {
    Admin finByUsername(String username);

    Admin save(AdminDto adminDto);
}
