package library_management_system;

import java.time.*;

public class IssueRecord {
    private Book book;
    private Member member;
    private LocalTime issueTime;
    private LocalTime dueTime;
    private LocalTime returnTime;

    public IssueRecord(){}
    
    public IssueRecord(Book book,Member member){
        this.book=book;
        this.member=member;
        this.issueTime=LocalTime.now();
        this.dueTime=issueTime.plusMinutes(10);
        this.returnTime=null;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalTime getIssueTime() {
        return issueTime;
    }

    public LocalTime getReturnTime() {
        return returnTime;
    }

    public LocalTime getDueTime() {
        return dueTime;
    }
    
    public boolean isReturned(){
        return returnTime!=null;
    }

    public void updateReturnTime() {
        returnTime=LocalTime.now();
    }

    
    public void displayIssueRecord(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("              ISSUE RECORD                    ");
        System.out.println("==============================================");
        System.out.println(" Member ID       : "+member.getId());
        System.out.println(" Member Name     : "+member.getName());
        System.out.println(" Book ID         : "+book.getBookID());
        System.out.println(" Book Title      : "+book.getTitle());
        System.out.println(" Issue Time      : "+issueTime);
        System.out.println(" Due Time        : "+dueTime);
        System.out.println(" Return Time     : "+(returnTime==null?"Not Returned":returnTime));
        System.out.println(" Status          : "+(isReturned()?"Returned":"Issued"));
        System.out.println("==============================================");
    }

}
