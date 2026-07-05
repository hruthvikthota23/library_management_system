package library_management_system;

public class Faculty extends Member{
    
    private String department;
    private String designation;

    public Faculty(){}

    public Faculty(int id,String name,String department,String designation){
        super(id,name);
        this.department=department;
        this.designation=designation;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }    

    @Override
    public void displayInfo(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("             FACULTY DETAILS                  ");
        System.out.println("==============================================");
        System.out.println(" ID              : "+getId());
        System.out.println(" Name            : "+getName());
        System.out.println(" Department      : "+department);
        System.out.println(" Designation     : "+designation);
        System.out.println(" Borrowed Books  : "+getBorrowedBooks());
        System.out.println("==============================================");    
    }

}
