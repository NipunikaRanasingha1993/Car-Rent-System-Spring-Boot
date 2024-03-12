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

    public Admin adminSave(AdminDto adminDto){
        return adminRepo.save(new Admin(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(), adminDto.getUserName(), adminDto.getPassword()));
    }


    public HashMap<String, String> loginAdmin(AdminDto adminDto) {

        HashMap<String, String> response = new HashMap<>();
        Admin adminByEmailAndPassword = adminRepo.findAdminByEmailAndPassword(adminDto.getEmail(), adminDto.getPassword());
        System.out.println(adminByEmailAndPassword);

        if (adminByEmailAndPassword != null) {
            String token = this.jwtTokenGenerator.generateJwtToken(adminDto);
            response.put("token", token);

        }

        else {
            response.put("message", "wrong Credentials");
        }

   return response;
    }
}



