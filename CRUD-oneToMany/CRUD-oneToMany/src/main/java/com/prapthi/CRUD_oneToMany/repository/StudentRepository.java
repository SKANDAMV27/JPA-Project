package com.prapthi.CRUD_oneToMany.repository;

import com.prapthi.CRUD_oneToMany.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
