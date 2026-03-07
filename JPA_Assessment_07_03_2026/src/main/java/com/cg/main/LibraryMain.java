package com.cg.main;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LibraryMain {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Select any of your choice: ");
            System.out.println("1 Add Author with books.");
            System.out.println("2 Read Author with books. ");
            System.out.println("3 Update price of the book");
            System.out.println("4 Delete a book");
            System.out.println("5 delete Author");
            System.out.println("6 exit");


            int choice = sc.nextInt();
                        sc.nextLine();

                        switch(choice)
                        {
                            case 1:
                                System.out.println("Enter author name:");
                                String author = sc.nextLine();

                                System.out.println("enter email");
                                String email = sc.nextLine();
                                Author a=new Author(author,email);

                                List<Book> books = new ArrayList<>();
                                for(int i =0;i<3;i++)
                                {
                                    System.out.println("Enter books data----");
                                    System.out.println("Enter book title: ");
                                    String title=sc.next();
                                    System.out.println("Enter price: ");
                                    double price=sc.nextDouble();
                                    Book b=new Book(title, price);
                                }
                                service.addAuthor(a,books);
                                break;

                            case 2:
                                service.getAuthors();
                                break;

                            case 3:
                                System.out.println("Enter Book ID:");
                                int bid = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Enter New Price:");
                                double price = sc.nextDouble();

                                service.updatePrice(bid,price);
                                break;

                            case 4:
                                System.out.println("Enter Book ID to delete:");
                                int bookid= sc.nextInt();
                                sc.nextLine();

                                service.deleteBook(bookid);
                                break;

                            case 5:
                                System.out.println("Enter Author Id:");
                                int id = sc.nextInt();
                                sc.nextLine();

                                service.deleteBook(id);
                                break;

                            case 6:
                                System.exit(0);

                            default:
                                System.out.println("Invalid Choice");
                        }
                    }
                }
            }

