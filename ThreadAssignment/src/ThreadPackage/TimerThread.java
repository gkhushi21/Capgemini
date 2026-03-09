package ThreadPackage;

public class TimerThread  implements Runnable {

        public void run() {
            int seconds = 0;
            try {
                while (true) {
                    Thread.currentThread().sleep(1000);
                    seconds += 1;
                    System.out.println("seconds: " +seconds);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public static void main(String[] args) {

            TimerThread t1=new TimerThread();
            Thread thread = new Thread();
            thread.start();

        }
    }



