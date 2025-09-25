package com.prapthi.CRUD_Many_To_Many.service;

import com.prapthi.CRUD_Many_To_Many.dto.CourseDTO;
import com.prapthi.CRUD_Many_To_Many.dto.StudentDTO;
import com.prapthi.CRUD_Many_To_Many.entity.CourseEntity;
import com.prapthi.CRUD_Many_To_Many.entity.StudentEntity;
import com.prapthi.CRUD_Many_To_Many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    public CourseDTO toCourseDto(CourseEntity courseEntity) {
        if (courseEntity == null) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(courseEntity.getId());
        courseDTO.setCourseName(courseEntity.getCourseName());

        if (courseEntity.getStudent() != null) {
            List<StudentDTO> studentDTOList = courseEntity.getStudent()
                    .stream()
                    .map(this::toStudentDto)
                    .collect(Collectors.toList());
            courseDTO.setStudentDTOList(studentDTOList);
        }
        return courseDTO;
    }

    public StudentDTO toStudentDto(StudentEntity studentEntity) {
        if (studentEntity == null) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setStudentName(studentEntity.getStudentName());
        studentDTO.setStudentBranch(studentEntity.getStudentBranch());

        if (studentEntity.getCourse() != null) {
            List<CourseDTO> courseDTOList = studentEntity.getCourse()
                    .stream()
                    .map(this::toCourseDto)
                    .collect(Collectors.toList());
            studentDTO.setCourseDTOList(courseDTOList);
        }
        return studentDTO;
    }



    public CourseEntity toCourseEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(courseDTO.getId());
        courseEntity.setCourseName(courseDTO.getCourseName());

        if (courseDTO.getStudentDTOList() != null) {
            List<StudentEntity> studentEntityList = courseDTO.getStudentDTOList()
                    .stream()
                    .map(this::toStudentEntity)
                    .collect(Collectors.toList());
            courseEntity.setStudent(studentEntityList);
        }
        return courseEntity;
    }

    public StudentEntity toStudentEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDTO.getId());
        studentEntity.setStudentName(studentDTO.getStudentName());
        studentEntity.setStudentBranch(studentDTO.getStudentBranch());

        if (studentDTO.getCourseDTOList() != null) {
            List<CourseEntity> courseEntityList = studentDTO.getCourseDTOList()
                    .stream()
                    .map(this::toCourseEntity)
                    .collect(Collectors.toList());
            studentEntity.setCourse(courseEntityList);
        }
        return studentEntity;
    }

        public StudentDTO save(StudentDTO studentDTO){
            System.out.println("Data Save");
            StudentEntity studentEntity = toStudentEntity(studentDTO);
            StudentEntity save =   studentRepository.save(studentEntity);
            return toStudentDto(save);
        }


}
