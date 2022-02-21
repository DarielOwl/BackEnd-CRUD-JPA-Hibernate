package com.sofka.JPA.Repository;

import com.sofka.JPA.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);

}