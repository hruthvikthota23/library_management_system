package library_management_system;

public class Book{

    private int bookID;
    private String title;
    private BookDetails details;
    private boolean availability;
    
    public Book(){}

    public Book(int bookID,String title,BookDetails details){
        this.bookID=bookID;
        this.title=title;
        this.details=details;
        availability=true;
    }
    
    public int getBookID() {
        return bookID;
    }
    
    public String getTitle() {
        return title;
    }
    
    public BookDetails getDetails() {
        return details;
    }
    
    public Boolean getAvailability() {
        return availability;
    }

    public void issueBook(){
        availability=false;
    }

    public void returnBook(){
        availability=true;
    }

    public void displayBook(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("               BOOK DETAILS                   ");
        System.out.println("==============================================");
        System.out.println(" Book ID        : "+getBookID());
        System.out.println(" Book Title     : "+getTitle());
        details.displayDetails();
        System.out.println(" Status         : "+(availability? "Available":"Issued"));
        System.out.println("==============================================");
    }
    
}
