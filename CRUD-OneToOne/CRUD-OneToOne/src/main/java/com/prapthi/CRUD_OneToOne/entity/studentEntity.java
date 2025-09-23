package com.prapthi.CRUD_OneToOne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class studentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String studentName;

    private String studentDept;

    private String studentContactNumber;

    @OneToOne(mappedBy = "")
    private resumeEntity resumeEntity;
}
