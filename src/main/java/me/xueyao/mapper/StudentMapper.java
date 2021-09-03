package me.xueyao.mapper;

import me.xueyao.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Simon.Xue
 * @date 2021-09-03 21:56:16
 **/
@Repository
public interface StudentMapper {
    /**
     * 保存
     * @param student
     * @return
     */
    int insertSelective(Student student);

    /**
     * 查询详情
     * @param id
     * @return
     */
    Student selectByPrimaryKey(@Param("id") Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("id") Integer id);

    /**
     * 更新
     * @param result
     * @return
     */
    int updateByPrimaryKeySelective(Student result);
}
