package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.AdminDto;
import lk.acpt.riyapola.entity.Admin;
import lk.acpt.riyapola.repo.AdminRepo;
import lk.acpt.riyapola.util.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(JWTTokenGenerator jwtTokenGenerator, AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin adminSave(AdminDto adminDto){
        return adminRepo.save(new Admin(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(), adminDto.getUserName(), adminDto.getPassword()));
    }

}



