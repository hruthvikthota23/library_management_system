package library_management_system;

import java.util.*;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<IssueRecord> records=new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void addBook() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("              ADD NEW BOOK                    ");
        System.out.println("==============================================");  
        System.out.print(" Book ID        : ");

        int id = sc.nextInt();
        sc.nextLine();
        for(Book book:books){
            if(id==book.getBookID()){
                System.out.println("----------------------------------------------");
                System.out.println("            Book ID Already Exists!");
                System.out.println("----------------------------------------------");                return;
            }
        }
        System.out.print(" Book Title     : ");
        String title = sc.nextLine();
        System.out.print(" Author Name    : ");
        String author = sc.nextLine();
        System.out.print(" Publisher      : ");
        String publisher = sc.nextLine();
        System.out.print(" Edition        : ");
        int edition = sc.nextInt();
        sc.nextLine();
        System.out.print(" Published Year : ");
        int year = sc.nextInt();
        BookDetails details=new BookDetails(author,publisher,edition,year);
        Book book = new Book(id, title, details);
        books.add(book);
        System.out.println("----------------------------------------------");
        System.out.println("           Book Added Successfully!");
        System.out.println("----------------------------------------------");
    }


    public void removeBook() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("              REMOVE BOOK                     ");
        System.out.println("==============================================");
        System.out.print(" Enter Book ID  : ");
        int id = sc.nextInt();
        System.out.println();
        for (Book book : books) {
            if (id == book.getBookID()) {
                if (book.getAvailability()) {
                    books.remove(book);
                    System.out.println("----------------------------------------------");
                    System.out.println("           Book Removed Successfully");
                    System.out.println("----------------------------------------------");
                    return;
                } else {
                    System.out.println("----------------------------------------------");
                    System.out.println("    Cannot Remove - Book Currently Issued!");
                    System.out.println("----------------------------------------------");
                    return;
                }
            }
        }
        System.out.println("----------------------------------------------");
        System.out.println("            Book Not Found!");
        System.out.println("----------------------------------------------");
    }


    public void searchBook() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("              SEARCH BOOK                     ");
        System.out.println("==============================================");
        System.out.println(" 1. Search By Book ID");
        System.out.println(" 2. Search By Title");
        System.out.println(" 3. Search By Author");
        System.out.println("----------------------------------------------");
        System.out.print(" Choose Search Option : ");
        int search = sc.nextInt();
        sc.nextLine();
        System.out.println();
        switch (search) {
            case 1 -> {
                System.out.print(" Enter Book ID  : ");
                int id = sc.nextInt();
                for (Book book : books) {
                    if (id == book.getBookID()) {
                        book.displayBook();
                        return;
                    }
                }
                System.out.println("----------------------------------------------");
                System.out.println("            Book Not Found!");
                System.out.println("----------------------------------------------");
            }
            case 2 -> {
                System.out.print(" Enter Book Title : ");
                String title = sc.nextLine();
                for(Book book:books){
                    if(title.equalsIgnoreCase(book.getTitle())){
                        book.displayBook();
                        return;
                    }
                }
                System.out.println("----------------------------------------------");
                System.out.println("            Book Not Found!");
                System.out.println("----------------------------------------------");
            }
            case 3 -> {
                System.out.print(" Enter Book Author : ");
                String author = sc.nextLine();
                for(Book book:books){
                    if(author.equalsIgnoreCase(book.getDetails().getAuthor())){
                        book.displayBook();
                        return;
                    }
                }
                System.out.println("----------------------------------------------");
                System.out.println("            Book Not Found!");
                System.out.println("----------------------------------------------");
            }
            default -> {
                System.out.println("----------------------------------------------");
                System.out.println("            Invaild Search");
                System.out.println("----------------------------------------------");
            }
        }
    }


    public void registerStudent(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("            STUDENT REGISTRATION              ");
        System.out.println("==============================================");
        System.out.print(" Student ID     : ");
        int id=sc.nextInt();
        sc.nextLine();
        for(Member member:members){
            if(id==member.getId()){
                System.out.println("----------------------------------------------");
                System.out.println("        Member ID Already Exists!");
                System.out.println("----------------------------------------------");
                return;
            }
        }
        System.out.print(" Name           : ");
        String name=sc.nextLine();
        System.out.print(" Branch         : ");
        String branch=sc.nextLine();
        System.out.print(" Semester       : ");
        int semester=sc.nextInt();
        Student student=new Student(id,name,branch,semester);
        members.add(student);
        System.out.println("----------------------------------------------");
        System.out.println("       Student Registered Successfully");
        System.out.println("----------------------------------------------");
    }
    
    
    public void registerFaculty(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("            FACULTY REGISTRATION              ");
        System.out.println("==============================================");
        System.out.print(" Faculty ID     : ");
        int id=sc.nextInt();
        sc.nextLine();
        for(Member member:members){
            if(id==member.getId()){
                System.out.println("----------------------------------------------");
                System.out.println("          Member ID Already Exists!");
                System.out.println("----------------------------------------------");
                return;
            }
        }
        System.out.print(" Name           : ");
        String name=sc.nextLine();
        System.out.print(" Department     : ");
        String department=sc.nextLine();
        System.out.print(" Designation    : ");
        String designation=sc.nextLine();
        Faculty faculty=new Faculty(id, name, department, designation);
        members.add(faculty);
        System.out.println("----------------------------------------------");
        System.out.println("      Faculty Registered Successfully");
        System.out.println("----------------------------------------------");
    }


    public void issueBook(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("                ISSUE BOOK                    ");
        System.out.println("==============================================");
        System.out.print(" Enter Member ID : ");
        int MemberID=sc.nextInt();
        sc.nextLine();
        for(Member member:members){
            if(MemberID==member.getId()){
                System.out.print(" Enter Book ID   : ");
                int bookID=sc.nextInt();
                sc.nextLine();
                System.out.println();
                for(Book book:books){
                    if(bookID==book.getBookID()){
                        if(book.getAvailability()){
                            if(member.canBorrow()){
                                book.issueBook();
                                member.borrowCount();
                                IssueRecord record=new IssueRecord(book, member);
                                records.add(record);
                                System.out.println("----------------------------------------------");
                                System.out.println("          Book Issued Successfully!");
                                System.out.println("----------------------------------------------");
                                return;
                            }
                            else{
                                System.out.println("----------------------------------------------");
                                System.out.println("           Borrow Limit Reached!");
                                System.out.println("----------------------------------------------");
                                return;
                            }
                        }
                        else{
                            System.out.println("----------------------------------------------");
                            System.out.println("            Book Already Issued!");
                            System.out.println("----------------------------------------------");
                            return;
                        }
                    }
                }
                System.out.println("----------------------------------------------");
                System.out.println("            Book Not Found!");
                System.out.println("----------------------------------------------");
                return;
            }
        }
        System.out.println("----------------------------------------------");
        System.out.println("   Member Not Found! Please Register First.");
        System.out.println("----------------------------------------------");
    }


    public void returnBook(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("                RETURN BOOK                   ");
        System.out.println("==============================================");
        System.out.print(" Enter Book ID  : ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println();
        for(Book book:books){
            if(id==book.getBookID()){
                if(!book.getAvailability()){
                    for(IssueRecord record:records){
                        if(id==record.getBook().getBookID() && !record.isReturned()){
                            book.returnBook();
                            record.getMember().returnCount();
                            record.updateReturnTime();
                            System.out.println("----------------------------------------------");
                            System.out.println("        Book Returned Successfully!");
                            System.out.println("----------------------------------------------");
                            return;
                        }
                    }
                }
                else{
                    System.out.println("----------------------------------------------");
                    System.out.println("           Book Was Not Issued!");
                    System.out.println("----------------------------------------------");
                    return;
                }
            }
        }
        System.out.println("----------------------------------------------");
        System.out.println("             Book Not Found!");
        System.out.println("----------------------------------------------");
    }


    public void viewBooks(){
        if(!books.isEmpty()){
            for(Book book:books){
                book.displayBook();
            }
        }
        else{
            System.out.println("----------------------------------------------");
            System.out.println("      No Book Found, Please Add Books!");
            System.out.println("----------------------------------------------");
        }
    }


    public void viewMembers(){
        if(!members.isEmpty()){
            for(Member member:members){
                member.displayInfo();
            }
        }
        else{
            System.out.println("----------------------------------------------");
            System.out.println("     No Registrations, Please Register!");
            System.out.println("----------------------------------------------");
        }
    }
    
    
    public void viewRecords(){
        if(!records.isEmpty()){
            for(IssueRecord record:records){
                record.displayIssueRecord();
            }
        }
        else{
            System.out.println("----------------------------------------------");
            System.out.println("            No Records Found!");
            System.out.println("----------------------------------------------");
        }
    }

}
