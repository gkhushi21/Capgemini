package Lambda_25feb;

interface Printable{
    A ans(String name, int age);
}
//class method{
//    public factorymethod()
//}
class A{
    private String name;
    private int age;

//    public Lambda_24feb.A(String name,int age){
//        this.name = name;
//        this.age = age;
//    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
class Factory{

    public A createObj(String n, int m){
        A a = new A();
        a.setName(n);
        a.setAge(m);
        return a;
    }
}

public class MainClass {
    public static void main(String[] args){
     Printable  creator = new Factory()::createObj;
     A a = creator.ans("Janvi", 20);
        System.out.println("Created person1: " + a.getName());
        System.out.println("Person1's age is: " + a.getAge());
    }

}//creation of instance using main method
