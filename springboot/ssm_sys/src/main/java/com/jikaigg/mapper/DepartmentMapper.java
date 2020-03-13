package com.jikaigg.mapper;

import com.jikaigg.domain.Department;
import com.jikaigg.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {
    /**
     * 根据id查询部门信息
     * @param deptId
     * @return
     */
    @Results(id = "department",value = {
            @Result(property = "deptId",column = "dept_id"),
            @Result(property = "deptName",column = "dept_name"),
            @Result(property = "deptLeader",column = "dept_leader")
    })
    @Select("select * from tbl_dept where dept_id = #{deptId}")
    Department selectOne(@Param("deptId")Integer deptId);

    /**
     * 根据部门名称查询部门信息
     * @param deptName
     * @return
     */
    @ResultMap(value = "department")
    @Select("select * from tbl_dept where dept_name = #{deptName}")
    Department selectOneByName(@Param("deptName")String deptName);

    /**
     * 根据部门领导名查部门信息
     * @param deptLeader
     * @return
     */
    @ResultMap(value = "department")
    @Select("select * from tbl_dept where dept_leader = #{deptLeader}")
    Department selectOneByLeader(@Param("deptLeader")String deptLeader);

    /**
     * 查询所有部门信息
     * @return
     */
    @ResultMap(value = "department")
    @Select("select * from tbl_dept")
    List<Department> selectAll();

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    @Update("update tbl_dept set dept_name = #{deptName},dept_leader = #{deptLeader} where dept_id = #{deptId}")
    int updateOne(Department department);

    /**
     * 删除部门信息
     * @param deptId
     * @return
     */
    @Delete("delete from tbl_dept where dept_id = #{deptId}")
    int deleteOne(@Param("deptId")Integer deptId);

    /**
     * 新增部门信息
     * @param department
     * @return
     */
    @Insert("insert into tbl_dept(dept_id,dept_name,dept_leader) values(#{deptId},#{deptName},#{deptLeader})")
    int insertDept(Department department);

    @Select("select * from tbl_emp e left join tbl_dept d on e.department_id = d.dept_id order by emp_id limit #{limit},#{offset}")
    List<Employee> selectLimitAndOffset(@Param("limit")Integer limit, @Param("offset")Integer offset);



    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tbl_dept")
    int countDepts();



    List<Department> findAll();


}
