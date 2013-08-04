import java.util.*; //for scanner
import java.io.*; //for BufferedReader
public class two_way_input {
    public static void main(String[] argv) throws IOException {
        String msg1 = "";
        String temp;

        //Input method of Scanner
        System.out.print("Enter any word and enter 'exit' to end the first input:");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            temp = sc.next();
            if (temp.equals("exit")) {
                break;
            }
            msg1 += temp + " ";
        }
        System.out.println("Your first input string is:" + msg1);

        //Input method of BufferedReader
        System.out.print("Enter any word and enter 'exit' to end the second input:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg2 = "";
        while ((temp = br.readLine()) != null) {
            if (temp.equals("exit")) {
                break;
            }
            msg2 += temp + "";
        }
        System.out.println("Your second input string is:" + msg2);


    }
}
