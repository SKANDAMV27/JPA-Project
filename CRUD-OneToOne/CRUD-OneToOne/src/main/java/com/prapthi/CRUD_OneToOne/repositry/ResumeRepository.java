package com.prapthi.CRUD_OneToOne.repositry;

import com.prapthi.CRUD_OneToOne.entity.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<ResumeEntity,Long> {
}
