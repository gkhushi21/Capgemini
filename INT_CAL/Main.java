package INT_CAL;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int ch;

            do {
                System.out.println("\nPick up your choice");
                System.out.println("1. AccountName – SB");
                System.out.println("2. AccountName – FD");
                System.out.println("3. AccountName – RD");
                System.out.println("4. Exit");

                 System.out.print("Enter your Choice: ");
                 ch = sc.nextInt();

                try {

                    switch (ch) {

                        case 1: // SB
                            System.out.println("Enter the total amount in your account:");
                            double Sbamount = sc.nextDouble();

                            System.out.println("Enter type of Account: Normal or NRI:");
                            String accType = sc.next();

                            if (Sbamount < 0)
                                throw new NegativeValueException("Invalid or negative input");

                            Account sb = new SBAccount(Sbamount, accType);
                            System.out.println("Interest amount : Rs. " + sb.calculateInterest());
                            break;

                        case 2: // FD
                            System.out.println("Enter the  amount in FD account:");
                            double Fdamount = sc.nextDouble();

                            System.out.println("Enter the number of days:");
                            int days = sc.nextInt();

                            System.out.println("Enter your age:");
                            int age = sc.nextInt();

                            if (Fdamount < 0 || days < 0 || age < 0)
                                throw new NegativeValueException("Invalid input entered");

                            Account fd = new FDAccount(Fdamount, days, age);
                            System.out.println("Interest amount: Rs. " + fd.calculateInterest());
                            break;

                        case 3: // RD
                            System.out.println("Enter the monthly amount:");
                            double monthlyAmount = sc.nextDouble();

                            System.out.println("Enter number of months:");
                            int months = sc.nextInt();

                            System.out.println("Enter your age:");
                            int rdAge = sc.nextInt();

                            if (monthlyAmount < 0 || months < 0 || rdAge < 0)
                                throw new NegativeValueException("Negative values are not allowed");

                            Account rd = new RDAccount(monthlyAmount, months, rdAge);
                            System.out.println("Interest amount: Rs. " + rd.calculateInterest());
                            break;

                        case 4:
                            System.out.println("Thank you!");
                            break;

                        default:
                            System.out.println("Invalid option. Try again.");
                    }

                } catch (NegativeValueException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter correct values.");
                    sc.nextLine(); // clear buffer
                }

            } while (ch != 4);

            sc.close();
        }
    }

