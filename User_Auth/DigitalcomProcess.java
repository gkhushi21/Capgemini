package User_Auth;

import java.util.Scanner;

public class DigitalcomProcess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User us = new User();

        System.out.println(" give user id  :");
        String id = sc.next();
        System.out.println(" give password  :");
        String pass = sc.next();


        if (!us.IsAuthenticated(id, pass)) {
            System.out.println("Not valid user , First register ");
            System.out.println("you want to register or not (true /false) : ");
            boolean str = sc.nextBoolean();

            if (true) {
                System.out.println("RegisterUser \n ");
                System.out.print("Add User_Auth.User Id :");
                id = sc.next();
                System.out.print(" Add Password:");
                pass = sc.next();
                us.addUser(id, pass);
                System.out.println("Added succssfuly : ");

            } else {
                System.out.print("Exit successfully");
                System.exit(100);
            }
        }
        int i = 6;
        while (i != 4) {
            System.out.print("\n select choice  :\n  1) RegisterUser \n 2) ViewGames  \n  3) searchByName \n  4) Exit\n  \nSelect choice no. : ");
            i = sc.nextInt();
            switch (i) {

                case 1: {
                    System.out.print(" give new user id to  add :");
                    id = sc.next();
                    System.out.print(" give new user password to add :");
                    pass = sc.next();
                    us.addUser(id, pass);
                    break;
                }

                case 2: {

                    System.out.println(GameService.viewAll());

                    break;
                }
                case 3:

                    System.out.print(" Give author name  :");
                    String auth = sc.next();
                    System.out.println(GameService.authorSearch(auth));

                    break;
                case 4:
                    break;
            }
            if (i == 4) {
                break;
            }
        }
        System.out.print("exit successfully");

    }
}











