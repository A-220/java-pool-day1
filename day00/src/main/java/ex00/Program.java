package ex00;

public class Program {
    public static void main(String[] args) {
        int ex = 479598;
        int res = 0;
        while(ex > 0) {
            res += ex % 10;
            ex /= 10;
        }
        System.out.println(res);
    }
}
