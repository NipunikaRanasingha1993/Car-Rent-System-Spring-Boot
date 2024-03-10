package lk.acpt.riyapola.repo;

import lk.acpt.riyapola.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {
    Admin findAdminDtoByEmailAndPassword(String email,String password);
}
