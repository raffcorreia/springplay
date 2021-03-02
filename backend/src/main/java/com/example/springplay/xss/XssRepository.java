package com.example.springplay.xss;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XssRepository extends JpaRepository<XssEntity, Long> {
}
