/*
 Project: Library Simulation System (Phase #1)
 Course: CSC 111
 Group Members: 1. Khalifa Al-Hashil , ID : 446104726
 */

import java.util.Scanner;
public class LibrarySimulator {
    public static void main(String[] args) {

        // Scanner For User Input //
        Scanner Input = new Scanner(System.in);

        // Predefined 3 Library Accounts //
        Member User_1 = new Member(446000000, "Bader Alhashil", 0 );

        Member User_2 = new Member(446111111, "Sultan Al-Khlaifi", 0 );
       

        Member User_3 = new Member(446222222, "Mohammed Al-Subaie", 0 );

       

        // This Will Store The User's Main Menu Choice
        int Choice;

        System.out.println("\n============================================= ");
        System.out.println("Welcome To The Library ");

        // A Do-While Loop Is Used Here So That The Menu Is Shown At Least Once
        do{


            System.out.println("============================================= ");
            System.out.println("\n  Please select an option : \n");

            System.out.printf("1. Login as " +  User_1.getName() + ", ID : " + User_1.getId() + "\n");
            System.out.printf("2. Login as " + User_2.getName() + ", ID : " + User_2.getId() + "\n");
            System.out.printf("3. Login as " + User_3.getName() + ", ID : " + User_3.getId() + "\n");
            System.out.println("4. Login as Administrator ");
            System.out.println("5. Exit the program ");

            System.out.print("\nEnter your choice : ");
            Choice = Input.nextInt();

            switch (Choice){
                case 1,2,3 -> {
Member currentMember;

                    if (Choice == 1) {
                        currentMember = User_1;
                    }
                    else if (Choice == 2) {
                        currentMember = User_2;
                    }
                    else {
                        currentMember = User_3;
                    }
                 currentMember.reset();
                    // Choice 2 Will Store The User Operations Menu Choice
                    int Choice2;

                    System.out.println("\n=============================================");
                    System.out.println("Welcome " + currentMember.getName() + " To The Library");

                    do {

     



                        System.out.println("=============================================");
                        System.out.println("\nUser Operations Menu:");

                        System.out.println("1. View Borrowed Books Count");
                        System.out.println("2. Borrow A Book ");
                        System.out.println("3. Return Book ");
                        System.out.println("4. View Session Summary ");
                        System.out.println("5. Exit To Main Menu \n");
                        System.out.print("Enter your choice: ");


                        Choice2 = Input.nextInt();

                        switch (Choice2){

                            case 1 ->
                            //View Borrowed Books Count
                            {
                                System.out.println("\n=============================================");
                                currentMember.viewBorrowedCount();

                            }

                            case 2 ->
                            // Borrow A Book
                            {
                                boolean success = currentMember.borrowOne();
                                
                                System.out.println("\n=============================================");
                                if (success) 
                                {
                                    System.out.println("You Successfully Borrowed 1 Book.");
                       
                                    currentMember.viewBorrowedCount(); 
                                } else 
                                {
                                    System.out.println("We're Sorry, You Can't Borrow More Than 5 Books");
                                }
                 
                                }
                                



                            
                    }
                            case 3 ->
                            //Return A Book
                            {
                             boolean success = currentMember.returnOne();
                                
                                System.out.println("\n=============================================");
                                if (success) {
                                    System.out.println("Thank You For Returning A Book.");
                                } else {
                                    System.out.println("You Dont Have Any Books Borrowed");
                                }
                            }
                            case 4 ->
                            //View Session Summary
                            {
                                currentMember.displayStatistics();
                            }

                            //Exit To The Main Menu
                            case 5 -> {
                                System.out.print("\n=============================================");
                                System.out.println("\n>> Logging out. Returning to the main menu...");

                            }

                            default -> {
                                System.out.println("\n=============================================");
                                System.out.println("Invalid Choice, Please select a valid option!");
                            }
                        }
                    }while (Choice2 != 5 );

                }
                case 4 -> {
                    System.out.print("\n============================================= ");
                    System.out.println("\n--- Welcome, Administrator! ---");
                    int adminChoice;

                    do {

                        System.out.println("============================================= ");
                        System.out.println("\nAdministrator Menu:");
                        System.out.println("1. View Total Revenue");
                        System.out.println("2. View Most Frequent Operation");
                        System.out.println("3. Exit to Main Menu");
                        System.out.print("Enter your choice : ");
                        adminChoice = Input.nextInt();

                        switch (adminChoice) {
                            case 1 -> {
                                System.out.println("\n=============================================");
                                System.out.printf("Total Revenue:  %.2f SAR %n" , Member.TotalRevenue );
                                System.out.println("=============================================");
                            }


                            case 2 -> {
                                System.out.println("1. View Total Revenue");
                        System.out.println("2. View Most Frequent Operation");
                        System.out.println("3. Exit to Main Menu");
                        System.out.print("Enter your choice : ");
                        adminChoice = Input.nextInt();

                        switch (adminChoice) {
                            case 1 -> {
                                System.out.println("\n=============================================");
                              
                                System.out.printf("Total Revenue:  %.2f SAR %n", Member.TotalRevenue);
                                System.out.println("=============================================");
                            }

                            case 2 -> {
                               
                                int borrows = Member.TotalBorrows;
                                int returns = Member.TotalReturns;

                                if (borrows > returns) {
                                    System.out.print("=============================================");
                                    System.out.println("Most Frequent Operation Is Borrowing (" + borrows + ")");
                                    System.out.println("=============================================\n");
                                } else if (borrows < returns) {
                                    System.out.println("=============================================");
                                    System.out.println("Most Frequent Operation Is Returning (" + returns + ")");
                                    System.out.println("=============================================\n");
                                } else {
                                    System.out.println("=============================================");
                                    System.out.println("Operations are equal: Borrowing (" + borrows + ") and Returning (" + returns + ")");
                                    System.out.println("=============================================\n");
                                }
                            }
                            case 3 -> {
                                System.out.print("=============================================");
                                System.out.println("\n>> Logging out. Returning to the main menu...");

                            }

                            default -> {
                                System.out.println("\n=============================================");
                                System.out.println("Invalid Choice, Please select a valid option!");
                            }


                        }
                    }while (adminChoice != 3 );

                }
                case 5 -> {
                    System.out.println("\n=============================================");
                    System.out.println("Thanks For Trying Our Library " );
                    System.out.println("=============================================");
                     }

                     default -> {

                         System.out.println("\n=============================================");
                         System.out.println("Invalid Choice, Please select a valid option!");

                     }
            }


        } while (Choice != 5);

        Input.close();
}
}
