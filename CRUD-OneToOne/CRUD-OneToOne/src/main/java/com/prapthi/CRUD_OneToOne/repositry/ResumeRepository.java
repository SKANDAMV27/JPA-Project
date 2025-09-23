package com.prapthi.CRUD_OneToOne.repositry;

import com.prapthi.CRUD_OneToOne.entity.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity,Long> {
}
