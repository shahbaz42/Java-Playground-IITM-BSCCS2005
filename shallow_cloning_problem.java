public class shallow_cloning_problem {
    public static void main(String[] args) {
        try {
            System.out.println("Before updating e1 and e2...");
            Employee e1 = new Employee("e1", 100, new Date(1,1,2000));
            System.out.println(e1);
            Employee e2 = (Employee) e1.clone();
            System.out.println(e2);
            e2.updateBirthday(new Date(2,2,2000));
            System.out.println("\nAfter updating Birthdate of clone e2 we can see that birthday od e1 gets updated.");
            System.out.println(e1);
            System.out.println(e2);
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}

class Date{
    int day, month, year;
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void updateDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString(){
        return "Date { day : " + day + ", month : " + month + ", year : " + year + " }";
    }

}

class Employee implements Cloneable{
    String name;
    int salary;
    Date birthday;

    public Employee(String name, int salary, Date birthday){
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public void updateBirthday(Date birthday){
        this.birthday.updateDate(birthday.day, birthday.month, birthday.year);
    }

    @Override
    public String toString(){
        String birthday_str = birthday.toString();
        return "Employee { name " + name + ", salary : " + salary + ", birthday : " + birthday_str + " }";
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}


