public class float_rounding {
    public static void main(String[] argv) {
        //declare a floating point number
        double x = 20.6;
        //JAVA will automatically round down to 20
        System.out.println((int)x);

        //use some tricky skill
        System.out.println((int)(x + 0.5));
        System.out.println(round(x));
    }

    public static int round(double y) {
        return (int)(y + 0.5);
    }
}
