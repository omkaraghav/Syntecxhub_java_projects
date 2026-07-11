public class Employee {
    private int id; private String name; private String department; private double salary;
    public Employee(int id,String name,String department,double salary){this.id=id;this.name=name;this.department=department;this.salary=salary;}
    public int getId(){return id;} public String getName(){return name;} public String getDepartment(){return department;} public double getSalary(){return salary;}
    public void setName(String n){name=n;} public void setDepartment(String d){department=d;} public void setSalary(double s){salary=s;}
    public String toString(){return "\nEmployee ID : "+id+"\nName : "+name+"\nDepartment : "+department+"\nSalary : ₹"+salary+"\n-----------------------------";}
}