package lk.acpt.riyapola.controller;


import lk.acpt.riyapola.dto.AdminDto;
import lk.acpt.riyapola.entity.Admin;
import lk.acpt.riyapola.repo.AdminRepo;
import lk.acpt.riyapola.service.AdminService;
import lk.acpt.riyapola.util.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    private final AdminRepo adminRepo;
    private final JWTTokenGenerator jwtTokenGenerator;

    @Autowired
    public AdminController(AdminService adminService, AdminRepo adminRepo, JWTTokenGenerator jwtTokenGenerator) {
        this.adminService = adminService;
        this.adminRepo = adminRepo;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<Admin> adminSave(@RequestBody AdminDto adminDto){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPassword = bCryptPasswordEncoder.encode(adminDto.getPassword());
        adminDto.setPassword(newPassword);
        Admin admin = adminService.adminSave(adminDto);
        return new ResponseEntity<>(admin,HttpStatus.CREATED);
    }



    @PostMapping("/login")
    public Map<String, String> loginAdmin(@RequestBody AdminDto adminDto){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Map<String,String> response = new HashMap<>();

        String findPw = adminRepo.findAdminByEmailToGetPw(adminDto.getEmail());

        Admin adminByEmail = adminRepo.findAdminByEmail(adminDto.getEmail());


        if(adminByEmail != null && bCryptPasswordEncoder.matches(adminDto.getPassword(), findPw)){
                String token = this.jwtTokenGenerator.generateJwtToken(adminByEmail);
                response.put("token", token);

            }

            else {
                response.put("message", "wrong Credentials");
            }

            return response;
        }


}
