package ThreadPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

    public class CopyDataThread extends Thread {

        FileInputStream fis;

        public CopyDataThread(FileInputStream stream) {
            this.fis=stream;

        }
        public void copy() throws IOException, InterruptedException {



            FileOutputStream fw = new FileOutputStream("Output.txt");

            int ch = 0;
            int counter = 0;
            while ((ch=fis.read()) != -1) {

                fw.write(ch);
                counter++;

                if (counter == 10) {
                    System.out.println("10 characters copied");
                    sleep(1000);
                    counter = 0;
                }

            }
            fw.close();
        }

        public void run() {
            try {
                copy();
            } catch (IOException | InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

