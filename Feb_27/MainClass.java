package Feb_27;

import java.util.Timer;

public class MainClass {
    public static void main(String[] args) {
        CopyDataThread c = new CopyDataThread();
                Thread t1 = new Thread(c);
        t1.start();
        DisplayTimerThread d = new DisplayTimerThread();
       Thread t2 = new Thread(d);
       t2.start();

    }
}
