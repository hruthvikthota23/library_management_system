package library_management_system;

public class Student extends Member{
    
    private String branch;
    private int semester;

    public Student() {}
    
    public Student(int id,String name,String branch,int semester){
        super(id,name);
        this.branch=branch;
        this.semester=semester;
    }
    
    public String getBranch() {
        return branch;
    }

    public int getSemester() {
        return semester;
    }

    @Override
    public int getBorrowLimit() {
        return 3;
    }
    
    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("             STUDENT DETAILS                  ");
        System.out.println("==============================================");
        System.out.println(" ID              : "+getId());
        System.out.println(" Name            : "+getName());
        System.out.println(" Branch          : "+branch);
        System.out.println(" Semester        : "+semester);
        System.out.println(" Borrowed Books  : "+getBorrowedBooks());
        System.out.println("==============================================");
    }


}
