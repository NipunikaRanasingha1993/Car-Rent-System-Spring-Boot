package lk.acpt.riyapola.repo;

import lk.acpt.riyapola.dto.AdminDto;
import lk.acpt.riyapola.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin,Long> {
//    Admin findAdminByEmailAndPassword(String email, String password);

    @Query(nativeQuery = true,value = "SELECT password FROM admin WHERE email= :email")
    String findAdminByEmailToGetPw(String email);

//    Admin findAdminByUserNameAndPassword(String email,String password);
    Admin findAdminByEmail(String email);

}
