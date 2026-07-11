import java.util.*; public class EmployeeManagement{
private HashMap<Integer,Employee> employees=new HashMap<>();
public void addEmployee(Employee e){if(employees.containsKey(e.getId())){System.out.println("Employee ID already exists!");return;}employees.put(e.getId(),e);System.out.println("Employee added successfully.");}
public void displayEmployees(){if(employees.isEmpty()){System.out.println("No employee records found.");return;}for(Map.Entry<Integer,Employee> en:employees.entrySet())System.out.println(en.getValue());}
public void searchEmployee(int id){Employee e=employees.get(id);System.out.println(e==null?"Employee not found.":e);}
public void updateEmployee(int id,String n,String d,double s){Employee e=employees.get(id);if(e==null){System.out.println("Employee not found.");return;}e.setName(n);e.setDepartment(d);e.setSalary(s);System.out.println("Employee updated successfully.");}
public void deleteEmployee(int id){System.out.println(employees.remove(id)!=null?"Employee deleted successfully.":"Employee not found.");}
}