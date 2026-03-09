package ThreadPackage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;

    public class FileProgram {

        public static void main(String[] args) throws FileNotFoundException {

            FileInputStream fis=new FileInputStream("source.txt");

            CopyDataThread cp=new CopyDataThread(fis);
            cp.start();

        }
    }

