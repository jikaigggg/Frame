package com.jikaigg.mapper;

import com.jikaigg.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 根据id查询员工信息
     *
     * @param empId
     * @return
     */
    @Results(
            id = "employee", value = {
            @Result(property = "empId", column = "emp_id", id = true),
            @Result(property = "empName", column = "emp_name"),
            @Result(property = "empEmail", column = "emp_email"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "departmentId", column = "department_id"),
    }
    )
    @Select("select * from tbl_emp where emp_id = #{empId}")
    Employee selectOneById(@Param("empId") Integer empId);

    /**
     * 根据姓名查询员工信息
     *
     * @param empName
     * @return
     */
    @ResultMap(value = "employee")
    @Select("select * from tbl_emp where emp_name = #{empName}")
    Employee selectOneByName(@Param("empName") String empName);

    /**
     * 查询带有部门信息的Employee
     *
     * @param empId
     * @return
     */
//    @ResultMap(value = {"employee","department"})
    @ResultMap(value = "employee")
    @Select("select * from tbl_emp e,tbl_dept d where e.department_id = d.dept_id and e.emp_id = #{empId}")
    Employee selectWithDeptById(@Param("empId") Integer empId);

    /**
     * 新增用户信息
     *
     * @param employee
     * @return
     */
    @ResultMap(value = "employee")
    @Insert("insert into tbl_emp(emp_name,emp_email,gender,department_id) values(#{empName},#{empEmail},#{gender},#{departmentId})")
    int insertOne(Employee employee);

    /**
     * 删除用户
     *
     * @param empId
     * @return
     */
    @ResultMap(value = "employee")
    @Delete("delete from tbl_emp where emp_id = #{empId}")
    int deleteOne(@Param("empId") Integer empId);

    /**
     * 修改用户
     *
     * @param employee
     * @return
     */
    @ResultMap(value = "employee")
    @Update("update tbl_emp set emp_name = #{empName},emp_email = #{empEmail},gender = #{gender},department_id = #{departmentId} where emp_id = #{empId}")
    int updateOne(Employee employee);

    //    @Select("select * from tbl_emp e left join tbl_dept d on e.department_id = d.dept_id order by emp_id limit #{limit},#{offset}")
    List<Employee> selectLimitAndOffset(@Param("limit") Integer limit, @Param("offset") Integer offset);

    /**
     * 查询总记录数
     *
     * @return
     */
    @Select("select count(*) from tbl_emp")
    int countEmps();


}
