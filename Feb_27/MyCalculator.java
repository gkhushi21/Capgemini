package Feb_27;
class Calculator extends Thread{
    int total;
    public void run(){
        for(int i = 0; i<=100;i++){
            total+=i;
        }
    }
}
public class MyCalculator {
    public static  void main(String[] args){
        Calculator cal = new Calculator();
        cal.start();
        System.out.println("Total="+cal.total );
    }
}
