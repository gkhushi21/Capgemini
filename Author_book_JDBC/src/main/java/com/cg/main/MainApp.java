package com.cg.main;

import java.util.Scanner;
import com.cg.bean.Author;
import com.cg.dao.AuthorDao;

public class MainApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        AuthorDao dao = new AuthorDao();

        System.out.println("1.Insert 2.Display 3.Update 4.Delete");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                sc.nextLine();
                System.out.println("Enter First Name:");
                String fn = sc.nextLine();

                System.out.println("Enter Middle Name:");
                String mn = sc.nextLine();

                System.out.println("Enter Last Name:");
                String ln = sc.nextLine();

                System.out.println("Enter Phone:");
                String ph = sc.nextLine();

                dao.addAuthor(new Author(fn, mn, ln, ph));
                break;

            case 2:
                System.out.println("Enter Author ID:");
                int id = sc.nextInt();
                dao.getAuthorById(id);
                break;

            case 3:
                System.out.println("Enter ID:");
                int uid = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter New Phone:");
                String phone = sc.nextLine();
                dao.updatePhone(uid, phone);
                break;

            case 4:
                System.out.println("Enter ID:");
                int did = sc.nextInt();
                dao.deleteAuthor(did);
                break;
        }
    }
}
