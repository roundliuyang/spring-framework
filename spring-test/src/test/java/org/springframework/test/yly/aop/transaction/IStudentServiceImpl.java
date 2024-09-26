package org.springframework.test.yly.aop.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Transactional
    public void saveStudent(String realname) throws Exception {
        Student student = new Student();
        student.setRealname(realname);
        System.out.println(student + "------------------");
    }
}
