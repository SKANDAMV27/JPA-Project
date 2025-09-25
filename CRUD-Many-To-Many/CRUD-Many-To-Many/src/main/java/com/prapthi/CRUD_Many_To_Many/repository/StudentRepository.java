package com.prapthi.CRUD_Many_To_Many.repository;

import com.prapthi.CRUD_Many_To_Many.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
