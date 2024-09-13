package com.koushik.repository;

import com.koushik.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

    public Admin findByAdminUserNameAndAdminPassword(String username,String password);

    public Admin findByAdminUserName(String username);

    public Admin findByAdminPassword(String password);
}
