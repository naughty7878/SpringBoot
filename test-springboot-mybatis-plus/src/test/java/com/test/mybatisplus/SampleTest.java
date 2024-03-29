package com.test.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.Employee;
import com.test.mybatisplus.enums.SexEnum;
import com.test.mybatisplus.mapper.EmployeeMapper;
import com.test.mybatisplus.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
public class SampleTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        List<Employee> userList = employeeMapper.selectList(null);
        userList.forEach(System.out::println);
    }


    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("qqq@qq.com");
//        employee.setGender(1);
        employee.setAge(20);
        employee.setSalary(BigDecimal.valueOf(100));
        int insert = employeeMapper.insert(employee);
        System.out.println("insert = " + insert);
        System.out.println("employee = " + employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(5L);
        employee.setEmail("");
//        employee.setGender(1);
        employee.setAge(40);
        int updateById = employeeMapper.updateById(employee);
        System.out.println("updateById = " + updateById);
        System.out.println("employee = " + employee);
    }


    @Test
    public void testSelect() {
        // 通过ID 查询
//        Employee employee = employeeMapper.selectById(5);
//        System.out.println("employee = " + employee);

        // 通过多个列进行查询
//        Employee employee = new Employee();
//        employee.setId(5);
//        employee.setLastName("MP");
//        SELECT id,last_name,gender,email,age FROM employee WHERE id=? AND last_name=?
//        Employee employee1 = employeeMapper.selectOne(new QueryWrapper<Employee>(employee));
//        System.out.println("employee1 = " + employee1);


        // 通过多个ID进行查询
//        List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(2, 3, 4, 5));
//        System.out.println("employees = " + employees);

        // 通过Map封装条件查询
//        Map<String, Object> param = new HashMap<>();
//        param.put("last_name", "MP");
//        List<Employee> employees = employeeMapper.selectByMap(param);
//        System.out.println("employees = " + employees);

    }

    @Test
    public void testSaveBatch() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setEmail("xx" + i + "@qq.com");
            employee.setLastName("xx" + i);
            employee.setAge(20 + i);
            list.add(employee);
        }
        boolean b = employeeService.saveBatch(list);
        System.out.println("b = " + b);
        for (Employee employee : list) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void testEnum() {
        Employee employee = new Employee();
        employee.setLastName("MPP");
        employee.setEmail("qqq@qq.com");
        employee.setGender(SexEnum.MALE);
        employee.setAge(20);
        employee.setSalary(BigDecimal.valueOf(100));
        int insert = employeeMapper.insert(employee);
        System.out.println("insert = " + insert);
        System.out.println("employee = " + employee);
    }
}