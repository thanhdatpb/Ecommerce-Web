package com.thanhdatpb.library.service.impl;

import com.thanhdatpb.library.dto.AdminDto;
import com.thanhdatpb.library.model.Admin;
import com.thanhdatpb.library.repository.AdminRepository;
import com.thanhdatpb.library.repository.RoleRepository;
import com.thanhdatpb.library.service.AdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AdminServiceImpl implements AdminService {
    private BCryptPasswordEncoder passwordEncoder;


    private final AdminRepository adminRepository;

    private final RoleRepository roleRepository;

    public AdminServiceImpl(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Admin finByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        admin.setRoles(Collections.singletonList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }
}