package library_management_system;

public class BookDetails {

    private String author;
    private String publisher;
    private int edition;
    private int year;

    public BookDetails() {
    }

    public BookDetails(String author, String publisher, int edition, int year) {
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void displayDetails() {
        System.out.println(" Author Name    : " + author);
        System.out.println(" Publisher      : "+publisher);
        System.out.println(" Edition        : "+edition);
        System.out.println(" Published Year : "+year);
    }

}
