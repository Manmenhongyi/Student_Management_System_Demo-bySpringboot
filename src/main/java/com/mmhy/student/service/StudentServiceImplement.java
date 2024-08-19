package com.mmhy.student.service;

import com.mmhy.student.converter.StudentConverter;
import com.mmhy.student.dao.Student;
import com.mmhy.student.dao.StudentRepository;
import com.mmhy.student.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

//StudentService的实现类
@Service
//定义spring服务层组件
public class StudentServiceImplement implements StudentService {
    @Autowired
    //自动装配bean并注入StudentRepository数据访问层接口
    private StudentRepository studentRepository;

    @Override
    //重写接口类中的getStudentById方法
    public StudentDTO getStudentById(long id) {
        //调用数据访问层接口的findById方法，并返回Student对象，如果没有找到则用orElseThrow方法抛出异常
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    //重写接口类中的addNewStudent方法

    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(studentList)) {
            throw new IllegalArgumentException("邮箱已存在");
        }
        Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));

        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("不存在id:" + id));
        studentRepository.deleteById(id);
    }

    @Override
    //@Transactional注解用于事务控制，保证数据一致性,出错时回滚
    @Transactional
    public StudentDTO updateStudentById(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("不存在id:" + id));
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) {
            //姓名不能相同
            studentInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
            //邮箱不能相同
            studentInDB.setEmail(email);
        }
        studentRepository.save(studentInDB);
        Student student=studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }
}
