public class Member {

    /*
 Project: Library Simulation System (Phase #2)
 Course: CSC 111
 Group Members: 1. Khalifa Al-Hashil , ID : 446104726
 */

    // Attributes
    private int id;
    private String name;
    private int borrowedCount;
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // Attributes
    public static double TotalRevenue = 0.0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;


    // Constructor
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
        //begin session stats with 0
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    //Checks if member can borrow
    private boolean canBorrow() {
        return borrowedCount < 5;
    }


    private boolean canReturn() {
        return borrowedCount > 0;
    }

    //method
    public void viewBorrowedCount() {
        this.numViewBorrowed++;
        TotalViewBorrowed++;

        System.out.println("\n=============================================");
        System.out.println("You Currently Have " + this.borrowedCount + " Books Right Now"); // [cite: 36]
    }

    public boolean borrowOne() {
        if (canBorrow()) {
            // Update User State
            this.borrowedCount++;
            this.numBorrows++;
            this.sessionFees += 0.50; // Charge 0.50 fee

            // Update Admin Global State
            TotalBorrows++;
            TotalRevenue += 0.50; // Add to total revenue

            return true; // Success
        } else {
            return false; // Failed limit reached
        }
    }

    public boolean returnOne() {
        if (canReturn()) {
            // Update User State
            this.borrowedCount--;
            this.numReturns++;

            // Update Admin
            TotalReturns++;

            return true; // Success
        } else {
            return false; //No books to return
        }
    }

    public void displayStatistics() {
        // Prints the member's session statistics
        System.out.println("\n=============================================");
        System.out.println("Total Book Borrows In This Session : " + this.numBorrows + " Book(s)");
        System.out.println("Total Book Returns In This Session : " + this.numReturns + " Book(s)");
        System.out.printf("You Have The Total Credit Fee of %.2f SAR %n", this.sessionFees);
    }

    public void reset() {
        // Resets the session statistics to zero
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

