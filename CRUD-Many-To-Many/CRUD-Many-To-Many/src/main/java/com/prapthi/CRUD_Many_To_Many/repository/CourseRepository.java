package com.prapthi.CRUD_Many_To_Many.repository;

import com.prapthi.CRUD_Many_To_Many.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
}
