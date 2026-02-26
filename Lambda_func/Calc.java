package Lambda_func;

import java.lang.*;
interface power{
   public int calculate( int x, int y);
}
interface space{
    public String modify(String s);
}
interface userNamePassword{
    boolean checkCredentials(String username,String password);
}
public class Calc {
    static power p =  (x,y) -> (int)(Math.pow(x,y));
    static space str =(s)->{
        //System.out.println(s);
        String str ="";
        for(int i = 0;i<s.length();i++){
            //System.out.println(s);
            str+=s.charAt(i)+" ";
           // System.out.println(str);
        }
        return str;
    };
//    static Lambda_func.userNamePassword str1 = ( username,password)->{
//       // username!=null ;
//        //password!=null;
//    }


    public static void main(String[] args) {
        String name = "khushi";
        String pass = "234";

        userNamePassword np = (x,y)->{
            if(x.equals(name)&&y.equals(pass))
                return true;
            return false;
        };
      System.out.println(p.calculate(2,3));
        System.out.println(str.modify("acd"));
        System.out.println(np.checkCredentials("khushi","234"));
    }
}
