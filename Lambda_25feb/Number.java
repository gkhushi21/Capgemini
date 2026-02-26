package Lambda_25feb;

class Fact{
    public int facto(int a){
        if(a==0||a==1)
            return 1;
        return a*facto(a-1);
    }
public class Number {
    public static void main(String[] args) {
        IFact f = new Fact():: facto;
        System.out.println(f.fact(4));

    }
    }
}
