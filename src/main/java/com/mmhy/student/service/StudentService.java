package com.mmhy.student.service;

import com.mmhy.student.dto.StudentDTO;
//StudentService的接口类

//抽象类，定义了获取学生信息的接口
public interface StudentService {
    //根据id获取学生信息的getStudentById方法
    StudentDTO getStudentById(long id);
    //新增学生信息的addNewStudent方法
    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentById(long id);

    StudentDTO updateStudentById(long id, String name, String email);
}
