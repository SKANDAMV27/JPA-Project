package com.prapthi.CRUD_OneToOne.repositry;

import com.prapthi.CRUD_OneToOne.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
