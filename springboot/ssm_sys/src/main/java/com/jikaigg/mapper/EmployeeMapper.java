package com.jikaigg.mapper;

import com.jikaigg.domain.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {
    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    @Results(
            id = "employee",value = {
                    @Result(property = "empId",column = "emp_id",id = true),
                    @Result(property = "empName",column = "emp_name"),
                    @Result(property = "empEmail",column = "emp_email"),
                    @Result(property = "gender",column = "gender"),
                    @Result(property = "departmentId",column = "department_id")
    }
    )
    @Select("select * from tbl_emp where emp_id = #{empId}")
    Employee selectOneById(@Param("empId") Integer empId);

    /**
     * 根据姓名查询员工信息
     * @param empName
     * @return
     */
    @Select("select * from tbl_emp where emp_name = #{empName}")
    Employee selectOneByName(@Param("empName") String empName);

    @Select("select * from tbl_emp e,tbl_dept d where e.department_id = d.dept_id and e.emp_id = #{emp_id}")
    Employee selectWithDeptById(@Param("empId") Integer empId);




}
