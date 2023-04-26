import java.lang.reflect.*;

public class reflections {
    public static void main(String[] args) {
        // Reflective Programming : Ability of a process to examine, introspect or modify its own structure.
        // Simplest type of reflection is using instanceOf operator
        System.out.println("Using operator instanceOf :");
        Person p1 = new Person("Shahbaz", 22);
        if( p1 instanceof Person ){
            System.out.println(" -> class of p1 is Person.");
        }

        // java provides getClass() method in java.lang.reflect;
        Class<?> c1 = p1.getClass();
        System.out.println(" -> Class of p1 (using getClass()) is :" + c1);

        System.out.println(" -> c1.getName() : " + c1.getName());
        System.out.println(" -> c1.getSimpleName() : " + c1.getSimpleName());
        System.out.println(" -> c1.isArray() : " + c1.isArray());
        System.out.println(" -> c1.hashCode() : " + c1.hashCode());

        // One can also get hold of the Class object by using the name of the class
        try{
            Class<?> c2 = Class.forName("Person");

            System.out.println("\nName of class" + c2.getName());
            // can also get Constructors using getConstructors()
            Constructor[] cArr = c2.getConstructors();
            System.out.println("\nConstructors of class Person : ");
            for(Constructor c : cArr){
                System.out.println(c);
                try{
                    Person p3 = (Person) c.newInstance("Madhavan", 35);
                    System.out.println("Person created using Constructor.newInstance() : " + p3);
                } catch (InstantiationException e){
                    System.out.println("Instantiation Exception.");
                } catch (InvocationTargetException e){
                    System.out.println("Invocation Target Exception");
                }
            }

            // can also get Methods and fields using getMethods() and getFilds()
            System.out.println("\nMethods of class Person: ");
            Method[] mArr = c2.getMethods();
            for(Method m : mArr){
                System.out.println("Method : " + m);
                String mName = m.getName();
                System.out.println("Method Name : " + mName);
                if(mName == "sum"){
                    Person p = new Person("Shahbaz", 22);
                    try {
                        System.out.println("Return type of method sum : "+m.getReturnType());
                        int result = (int) m.invoke(p, 1,2);
                        System.out.println("result of m.invoke() : " +  result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Illegal Argument Exception.");
                    } catch (InvocationTargetException e ){
                        System.out.println("Invocation Target Exception");
                    }
                }
                
            }

            System.out.println("\nFields (public) of class Person: ");
            Field[] fArr = c2.getFields();
            for(Field f : fArr){
                System.out.println("Field : " + f);
                System.out.println("field.getName() :" + f.getName()); 
                System.out.println("field.getType() :" + f.getType());
                Person p2 = new Person("Anup", 23); 
                System.out.println("field.get(p2) :" + f.get(p2));
            }

            System.out.println("\nFields (public, private) of class Person: ");
            Field[] fArr2 = c2.getDeclaredFields();
            for(Field f : fArr2){
                System.out.println(f);
                System.out.println("Field : " + f);
                System.out.println("field.getName() :" + f.getName()); 
                System.out.println("field.getType() :" + f.getType());
                Person p2 = new Person("Anup", 23);
                if (f.getName() == "name" ){
                    f.set(p2, "Venket" );
                }
                System.out.println("field.get(p1) :" + f.get(p2));
            }
            
        } catch (ClassNotFoundException e){
            System.out.println("Class is not found.");
        } catch (IllegalAccessException e){
            System.out.println("IllegalAccessException.");
        }

    }
}

class Person{
    public String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "Person { name : " + name + ", age : " + age + " }";
    }

    public Integer sum(int a, int b){
        return a + b ;
    }
}

/*
Output : 
Using operator instanceOf :
 -> class of p1 is Person.
 -> Class of p1 (using getClass()) is :class Person
 -> c1.getName() : Person
 -> c1.getSimpleName() : Person
 -> c1.isArray() : false
 -> c1.hashCode() : 1995265320

Name of classPerson

Constructors of class Person :
public Person(java.lang.String,int)
Person created using Constructor.newInstance() Person { name : Madhavan, age : 35 }

Methods of class Person:
Method : public java.lang.String Person.toString()
Method Name : toString
Method : public java.lang.Integer Person.sum(int,int)
Method Name : sum
Return type of method sum : class java.lang.Integer
result of m.invoke() : 3
Method : public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
Method Name : wait
Method : public final void java.lang.Object.wait() throws java.lang.InterruptedException
Method Name : wait
Method : public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
Method Name : wait
Method : public boolean java.lang.Object.equals(java.lang.Object)
Method Name : equals
Method : public native int java.lang.Object.hashCode()
Method Name : hashCode
Method : public final native java.lang.Class java.lang.Object.getClass()
Method Name : getClass
Method : public final native void java.lang.Object.notify()
Method Name : notify
Method : public final native void java.lang.Object.notifyAll()
Method Name : notifyAll

Fields (public) of class Person:
Field : public java.lang.String Person.name
field.getName() :name
field.getType() :class java.lang.String
field.get(p2) :Anup

Fields (public, private) of class Person:
public java.lang.String Person.name
Field : public java.lang.String Person.name
field.getName() :name
field.getType() :class java.lang.String
field.get(p1) :Venket
private int Person.age
Field : private int Person.age
field.getName() :age
field.getType() :int
IllegalAccessException.

*/
