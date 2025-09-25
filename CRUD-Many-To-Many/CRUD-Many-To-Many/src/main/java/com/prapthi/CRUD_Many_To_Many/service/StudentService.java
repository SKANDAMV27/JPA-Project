package com.prapthi.CRUD_Many_To_Many.service;

import com.prapthi.CRUD_Many_To_Many.dto.CourseDTO;
import com.prapthi.CRUD_Many_To_Many.dto.StudentDTO;
import com.prapthi.CRUD_Many_To_Many.entity.CourseEntity;
import com.prapthi.CRUD_Many_To_Many.entity.StudentEntity;
import com.prapthi.CRUD_Many_To_Many.repository.StudentRepository;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public CourseDTO toCourse(CourseEntity courseEntity) {
        if (courseEntity == null) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(courseEntity.getId());
        courseDTO.setCourseName(courseEntity.getCourseName());

        if (courseEntity.getStudent() != null) {
            List<StudentDTO> studentDTOList = courseEntity.getStudent()
                    .stream()
                    .map(this::toStudent)   // Convert StudentEntity → StudentDTO
                    .collect(Collectors.toList());
            courseDTO.setStudentDTOList(studentDTOList);
        }
        return courseDTO;
    }


    public StudentDTO toStudent(StudentEntity studentEntity){
        if(studentEntity==null){
            return null;
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setStudentName(studentEntity.getStudentName());
        studentDTO.setStudentBranch(studentEntity.getStudentBranch());

        if(studentEntity.getCourse()!=null){
            List<CourseDTO> studentDTOList = studentEntity.getCourse().stream()
                    .map(this::toCourse).collect(Collectors.toList()).reversed();
            studentDTO.setCourseDTOList(studentDTOList);
        }
        return studentDTO;
    }


}
