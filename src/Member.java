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

}

