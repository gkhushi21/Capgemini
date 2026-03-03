package com.cg.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;

    public class EmployeeDao implements IEmployeeDao{
        private static Connection con;
        static {
            try {
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Navru@29");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        @Override
        public String saveEmployee(Employee emp) {
            try {
                PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
                ps.setString(1, emp.getEmpid());
                ps.setString(2, emp.getName());
                ps.setString(3, emp.getEmail());
                ps.setString(4, emp.getDob());
                int rows=ps.executeUpdate();
                if(rows>0)
                    return "Employee Created";
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "Employee Not Created";
        }

        @Override
        public Employee findEmployee(String empid) {
            // TODO Auto-generated method stub
            try {
                PreparedStatement ps = con.prepareStatement("select * from employee where empid =?");
                ps.setString(1, empid);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    Employee emp = new Employee();
                    emp.setEmpid(rs.getString(1));
                    emp.setName(rs.getString(2));
                    emp.setEmail(rs.getString(3));
                    emp.setDob(rs.getString(4));
                    return emp;
                }

            } catch(SQLException e) {
                   e.printStackTrace();
            }
            return null;
        }
        @Override
        public List<Employee> getAll() {
            // TODO Auto-generated method stub
             List<Employee> list = new ArrayList<>();
             try{
                 PreparedStatement ps = con.prepareStatement("select * from employee");
                 ResultSet rs = ps.executeQuery();

                 while(rs.next()){
                     Employee emp = new Employee();
                     emp.setEmpid(rs.getString(1));
                     emp.setName(rs.getString(2));
                     emp.setEmail(rs.getString(3));
                     emp.setDob(rs.getString(4));

                     list.add(emp);
                 }

             }catch(SQLException e){
                 e.printStackTrace();
             }
            return list;
        }

        @Override
        public String updateEmployeeName(String empid, String newName) {
            // TODO Auto-generated method stub
            try {
                PreparedStatement ps = con.prepareStatement("update employee set name =? where empid =?");
                ps.setString(1,newName);
                ps.setString(2,empid);
                int rows = ps.executeUpdate();
                if(rows>0)
                    return "Employee Updated";
                else
                    return "employee not found";

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "update failed";
        }

        @Override
        public String deleteEmployee(String empid) {
            // TODO Auto-generated method stub
            try{
                PreparedStatement ps = con.prepareStatement("delete from employee where empid=?");
                ps.setString(1,empid);

                int rows = ps.executeUpdate();

                if(rows>0)
                    return "Employee Deleted";
                else
                    return "Employee not found";

            }catch(SQLException e){
                e.printStackTrace();
            }
            return "delete failed";
        }

    }

