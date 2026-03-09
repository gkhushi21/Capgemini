package Feb_27;

public class AccThread {
    public static void main(String[] args) {
        Account acc = new Account();
        Account acc1 = new Account();
        Account acc2 = new Account();
        Thread t1 = new Thread(acc,"Khushi");
        Thread t2 = new Thread(acc1,"john");
        Thread t3 = new Thread(acc2,"Martin");

        t1.start();
        t2.start();
        t3.start();
    }
}
