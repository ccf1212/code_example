class Test {
    int num = 100;

    void edit_num(int num) {
        System.out.println("Local Variable num: " + num);
        System.out.println("Member Attribute num: " + this.num);
    }
}

public class class_shadowing {
    public static void main(String[] argv) {
        Test case1 = new Test();
        case1.edit_num(200);
    }
}
