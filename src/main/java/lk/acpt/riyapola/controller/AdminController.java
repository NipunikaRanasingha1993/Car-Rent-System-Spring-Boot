package lk.acpt.riyapola.controller;


import lk.acpt.riyapola.dto.AdminDto;
import lk.acpt.riyapola.entity.Admin;
import lk.acpt.riyapola.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/save")
    public ResponseEntity<Admin> adminSave(@RequestBody AdminDto adminDto){
        Admin admin = adminService.adminSave(adminDto);
        return new ResponseEntity<>(admin,HttpStatus.CREATED);
    }



    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> loginAdmin(@RequestBody AdminDto adminDto){
        HashMap<String, String> string = adminService.loginAdmin(adminDto);
        return new ResponseEntity<>(string,HttpStatus.CREATED);
    }
}
