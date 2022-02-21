package com.sofka.JPA.Repository;

import com.sofka.JPA.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
    Project findByName(String name);
}
