package library_management_system;

public abstract class Member {

    private int id;
    private String name;
    private int borrowedBooks;

    public Member(){}

    public Member(int id,String name){
        this.id=id;
        this.name=name;
        this.borrowedBooks=0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowCount(){
        borrowedBooks++;
    }
    
    public void returnCount(){
        if(borrowedBooks>0){
            borrowedBooks--;
        }
    }
    
    public boolean canBorrow(){
        return borrowedBooks<getBorrowLimit();
    }
    
    public abstract int getBorrowLimit();
    
    public abstract void displayInfo();
}
