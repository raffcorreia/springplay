package com.example.springplay.sqlinjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    List<LoginEntity> findAllByName(String name);
    LoginEntity findOneByNameAndPassword(String name, String password);
}
