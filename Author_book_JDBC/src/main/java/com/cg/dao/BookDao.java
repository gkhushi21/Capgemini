package com.cg.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Book;
import com.cg.util.DBUtil;

public class BookDao {

    private Connection con = DBUtil.getConnection();

    // 1️⃣ Insert Book only
    public int insertBook(Book book) throws SQLException {

        String sql = "INSERT INTO book(title, price) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, book.getTitle());
        ps.setDouble(2, book.getPrice());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);   // return generated ISBN
        }

        return 0;
    }

    // 2️⃣ Insert Book and Map with Author
    public void insertBookWithAuthor(Book book, int authorId) throws SQLException {

        int isbn = insertBook(book);

        String sql = "INSERT INTO book_author(isbn, authorId) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, isbn);
        ps.setInt(2, authorId);

        ps.executeUpdate();

        System.out.println("Book inserted and mapped successfully!");
    }

    // 3️⃣ Get all Books by Author Name
    public List<Book> getBooksByAuthor(String authorName) throws SQLException {

        List<Book> list = new ArrayList<>();

        String sql = "SELECT b.isbn, b.title, b.price " +
                "FROM book b " +
                "JOIN book_author ba ON b.isbn = ba.isbn " +
                "JOIN author a ON a.authorId = ba.authorId " +
                "WHERE a.firstName = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, authorName);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Book book = new Book(
                    rs.getInt("isbn"),
                    rs.getString("title"),
                    rs.getDouble("price")
            );
            list.add(book);
        }

        return list;
    }

    // 4️⃣ Update price of books by Author name
    public void updateBookPriceByAuthor(String authorName, double newPrice)
            throws SQLException {

        String sql = "UPDATE book b " +
                "JOIN book_author ba ON b.isbn = ba.isbn " +
                "JOIN author a ON a.authorId = ba.authorId " +
                "SET b.price = ? " +
                "WHERE a.firstName = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, newPrice);
        ps.setString(2, authorName);

        int rows = ps.executeUpdate();

        System.out.println(rows + " book(s) updated successfully!");
    }

    // 5️⃣ Display All Books
    public List<Book> getAllBooks() throws SQLException {

        List<Book> list = new ArrayList<>();

        String sql = "SELECT * FROM book";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Book book = new Book(
                    rs.getInt("isbn"),
                    rs.getString("title"),
                    rs.getDouble("price")
            );
            list.add(book);
        }

        return list;
    }
}
