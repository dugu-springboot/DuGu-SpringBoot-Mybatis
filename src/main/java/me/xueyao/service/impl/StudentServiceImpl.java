package me.xueyao.service.impl;

import me.xueyao.base.R;
import me.xueyao.domain.Student;
import me.xueyao.mapper.StudentMapper;
import me.xueyao.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author Simon.Xue
 * @date 2021-09-03 21:41:12
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public R insert(Student student) {
        student.setCreateTm(new Date());
        student.setCreator("admin");
        studentMapper.insertSelective(student);
        return R.ofSuccess("添加成功");
    }

    @Override
    public R<Student> getById(Integer id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return R.ofSuccess("查询成功", student);
    }

    @Override
    public R update(Student student) {
        Student result = studentMapper.selectByPrimaryKey(student.getId());
        if (Objects.isNull(result)) {
            return R.ofParam("数据不存在");
        }
        BeanUtils.copyProperties(student, result);
        result.setUpdater("admin");
        result.setUpdateTm(new Date());
        studentMapper.updateByPrimaryKeySelective(result);
        return R.ofSuccess("更新成功");
    }

    @Override
    public R delete(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
        return R.ofSuccess("删除成功");
    }
}
