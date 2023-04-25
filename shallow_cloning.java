public class shallow_cloning {
    public static void main(String[] args) {
        Employee e1 = new Employee("e1", 100);
        System.out.println(e1);
        try {
            Employee e2 = (Employee) e1.clone();
            System.out.println(e2);
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}

class Employee implements Cloneable{
    String name;
    int salary;

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee { name " + name + ", salary : " + salary + " }";
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}


