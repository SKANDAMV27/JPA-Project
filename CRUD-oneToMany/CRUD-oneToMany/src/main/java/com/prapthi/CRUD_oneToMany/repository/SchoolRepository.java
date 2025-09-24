package com.prapthi.CRUD_oneToMany.repository;

import com.prapthi.CRUD_oneToMany.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity,Long> {
}
