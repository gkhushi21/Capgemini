package Feb_27;

public class Account implements Runnable{
    private static double accBalance = 20000;
    public void withdraw(String name,double amt){
        synchronized(this){
            if(amt<accBalance){
                System.out.println(name+ "is going to withdraw");
                accBalance = accBalance-amt;
            }else{
                System.out.println(name + "has not enough balance");
            }
        }
        System.out.println(name + "has available balance is: " + accBalance);
    }

    public void run(){
        withdraw(Thread.currentThread().getName(),10000);
    }
}
