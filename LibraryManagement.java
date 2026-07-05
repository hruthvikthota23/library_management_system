package library_management_system;

import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        System.out.println();
        System.out.println("==============================================");
        System.out.println("        WELCOME TO SN LIBRARY SYSTEM          ");
        System.out.println("==============================================");
        boolean menu = true;
        while (menu) {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("                 MAIN MENU                    ");
            System.out.println("==============================================");
            System.out.println("  1.  Add Book");
            System.out.println("  2.  Remove Book");
            System.out.println("  3.  Search Book");
            System.out.println("  4.  Register Student");
            System.out.println("  5.  Register Faculty");
            System.out.println("  6.  Issue Book");
            System.out.println("  7.  Return Book");
            System.out.println("  8.  View All Books");
            System.out.println("  9.  view All Members");
            System.out.println(" 10.  view All Records");
            System.out.println(" 11.  Exit");
            System.out.println("==============================================");
            System.out.print(" Enter your Choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.removeBook();
                    break;
                case 3:
                    library.searchBook();
                    break;
                case 4:
                    library.registerStudent();
                    break;
                case 5:
                    library.registerFaculty();
                    break;
                case 6:
                    library.issueBook();
                    break;
                case 7:
                    library.returnBook();
                    break;
                case 8:
                    library.viewBooks();
                    break;
                case 9:
                    library.viewMembers();
                    break;
                case 10:
                    library.viewRecords();
                    break;
                case 11:
                    System.out.println("==============================================");
                    System.out.println("                THANK YOU!");
                    System.out.println("==============================================");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invaild Choice");
                    ;
            }
            // System.out.println("\nContinue (yes/no)");
            // if ("no".equals(sc.nextLine())) {
                // menu = false;
            // }
        }
    }
}
