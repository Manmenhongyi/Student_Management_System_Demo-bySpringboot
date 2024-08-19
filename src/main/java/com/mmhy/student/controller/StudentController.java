package com.mmhy.student.controller;

import com.mmhy.student.Response;
import com.mmhy.student.dto.StudentDTO;
import com.mmhy.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//定义springMVC服务端的控制器组件
@CrossOrigin(origins = "http://localhost:8888") // 只允许来自8888端口的跨域请求
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student/{id}")
    //映射URL路径，并返回Student对象
    public Response<StudentDTO> getStudent(@PathVariable long id){
        //@PathVariable是SpringMVC中的一个注解，用于从URL路径中提取变量值并将其作为参数传递给控制器方法
        return Response.newSuccess(studentService.getStudentById(id));
        //返回Response对象，其中包含StudentDTO对象
    }
    @GetMapping("/student")
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO){
        //@RequestBody是SpringMVC中的一个注解，用于将请求体中的JSON数据绑定到一个对象上
        //接收StudentDTO对象，并将其转换为Student对象，再调用服务层方法添加到数据库中
        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }
    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id){
        //接收学生ID，并调用服务层方法删除数据库中的记录
        studentService.deleteStudentById(id);
    }
    @PutMapping("/student/{id}")
    public Response<StudentDTO> updateStudent(@PathVariable long id, @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String email){
        return Response.newSuccess(studentService.updateStudentById(id,name,email));
    }
}
