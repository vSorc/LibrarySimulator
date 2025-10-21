
/*
 * Project: Library Simulation System (Phase #1)
 * Course: CSC 111 - Computer Programming - I
 * Group Members:
 * 1. Khalifa Al-Hashil , 446104726

 */

import java.util.Scanner;

public class LibrarySimulator {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        int User_ID1 = 446123456 , User_Books1 = 0 ;
        String User_Name1 = "Bader Al-Hashil" ;

        int User_ID2 = 446012345 , User_Books2 = 0;
        String User_Name2 = "Sultan Al-Khlaifi" ;

        int User_ID3 = 446000000 , User_Books3 = 0;
        String User_Name3 = "Mohammed Al-Subaie" ;

        double totalRevenue = 0.0;
        int TotalBorrows = 0;
        int TotalReturns = 0;

        int Choice;

        System.out.println("\n============================================= ");
        System.out.println("Welcome To The Library ");

        do{


            System.out.println("============================================= ");
            System.out.println("\n  Please select an option : \n");

            System.out.printf("1. Login as " + User_Name1 + ", ID : " + User_ID1 + "\n");
            System.out.printf("2. Login as " + User_Name2 + ", ID : " + User_ID2 + "\n");
            System.out.printf("3. Login as " + User_Name3 + ", ID : " + User_ID3 + "\n");
            System.out.println("4. Login as Administrator ");
            System.out.println("5. Exit the program ");

            System.out.print("\nEnter your choice : ");
            Choice = Input.nextInt();

            switch (Choice){
                case 1,2,3 -> {

                    int sessionBorrows = 0;
                    int sessionReturns = 0;
                    double sessionFees = 0.0;
                    String currentUserName = "";


                    if (Choice == 1) {
                        currentUserName = User_Name1;
                    }
                    else if (Choice == 2) {
                        currentUserName = User_Name2;
                    }
                    else {
                        currentUserName = User_Name3;
                    }
                    int Choice2;
                    System.out.println("\n=============================================");
                    System.out.println("Welcome " + currentUserName + " To The Library");

                    do {

                        int currentUserBooks = 0;
                        if (Choice == 1) currentUserBooks = User_Books1;
                        else if (Choice == 2) currentUserBooks = User_Books2;
                        else currentUserBooks = User_Books3;



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

                            case 1 -> {
                                System.out.println("\n=============================================");
                                System.out.println("You Currently Have " + currentUserBooks + " Books Right Now");

                            }

                            case 2 -> {
                                if (currentUserBooks < 5 ) {
                                    if (Choice == 1) User_Books1++;
                                    else if (Choice == 2) User_Books2++;
                                    else User_Books3++;
                                    currentUserBooks++;


                                    System.out.println("\n=============================================");
                                    System.out.println("You Successfully Borrowed 1 Book, Total Books Borrowed : " + currentUserBooks );

                                    sessionBorrows++;
                                    sessionFees += 0.50;
                                    totalRevenue += 0.50;
                                    TotalBorrows ++;
                                }
                                else if (currentUserBooks == 5) {
                                    System.out.println("\n=============================================");
                                    System.out.println("We're Sorry, You Can't Borrow More Than 5 Books");
                                }



                            }
                            case 3 -> {
                                if (currentUserBooks == 0 ) {
                                    System.out.println("\n=============================================");
                                    System.out.println("You Dont Have Any Books Borrowed");
                                }
                                else {
                                    if (Choice == 1) User_Books1--;
                                    else if (Choice == 2) User_Books2--;
                                    else User_Books3--;

                                    sessionReturns++;

                                    System.out.println("\n=============================================");
                                    System.out.println("Thank You For Returning "+ sessionReturns  + " Book(s) Out Of " + sessionBorrows + " Book(s)");



                                    TotalReturns++;


                                }
                            }
                            case 4 -> {
                                System.out.println("\n=============================================");
                                System.out.println("Total Book Borrows In This Session : " + sessionBorrows + " Book(s)");
                                System.out.println("Total Book Returns In This Session : " + sessionReturns + " Book(s)");
                                System.out.println("You Have The Total Credit Fee of  " + sessionFees + " SAR\n");
                            }
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
                case 4 -> {}
                case 5 -> {}

            }


        } while (Choice != 5);

        Input.close();
}
}