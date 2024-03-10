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

    private final JWTTokenGenerator jwtTokenGenerator;
    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(JWTTokenGenerator jwtTokenGenerator, AdminRepo adminRepo) {
        this.jwtTokenGenerator = jwtTokenGenerator;
        this.adminRepo = adminRepo;
    }


    public HashMap<String, String> loginAdmin(AdminDto adminDto) {

        HashMap<String, String> response = new HashMap<>();
        Admin adminDtoByEmailAndPassword = adminRepo.findAdminDtoByEmailAndPassword(adminDto.getEmail(), adminDto.getPassword());
        if (adminDtoByEmailAndPassword != null) {
            String token = this.jwtTokenGenerator.generateJwtToken(adminDtoByEmailAndPassword);
            response.put("token", token);
        } else {
            response.put("message", "wrong Credentials");
        }
    }
}



