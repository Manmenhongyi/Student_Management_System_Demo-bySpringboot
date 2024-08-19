package com.mmhy.student.converter;

import com.mmhy.student.dao.Student;
import com.mmhy.student.dto.StudentDTO;


public class StudentConverter {
    //Student对象转换为StudentDTO对象
    public static StudentDTO convertStudent(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    //StudentDTO对象转换为Student对象
    public static Student convertStudent(StudentDTO studentDTO){
        Student student = new Student();
//        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        return student;
    }
}
