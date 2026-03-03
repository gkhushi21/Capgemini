package com.cg.dao;



import java.sql.*;
import com.cg.bean.Author;
import com.cg.util.DBUtil;

public class AuthorDao {

    Connection con = DBUtil.getConnection();

    // INSERT
    public void addAuthor(Author author) throws SQLException {

        String sql = "insert into author(firstName,middleName,lastName,phoneNo) values(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, author.getFirstName());
        ps.setString(2, author.getMiddleName());
        ps.setString(3, author.getLastName());
        ps.setString(4, author.getPhoneNo());

        ps.executeUpdate();
        System.out.println("Author inserted successfully!");
    }

    // DISPLAY BY ID
    public void getAuthorById(int id) throws SQLException {

        String sql = "select * from author where authorId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("authorId"));
            System.out.println("Name: " + rs.getString("firstName") + " "
                    + rs.getString("middleName") + " "
                    + rs.getString("lastName"));
            System.out.println("Phone: " + rs.getString("phoneNo"));
        } else {
            System.out.println("Author not found!");
        }
    }

    // UPDATE
    public void updatePhone(int id, String phone) throws SQLException {

        String sql = "update author set phoneNo=? where authorId=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, phone);
        ps.setInt(2, id);

        ps.executeUpdate();
        System.out.println("Updated successfully!");
    }

    // DELETE
    public void deleteAuthor(int id) throws SQLException {

        String sql = "delete from author where authorId=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Deleted successfully!");
    }
}
