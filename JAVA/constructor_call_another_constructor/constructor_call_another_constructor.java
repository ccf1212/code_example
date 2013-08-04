class Animal {
    int foot;
    int hand;
    int head;
    Animal(int foot) {
        this.foot = foot;
        this.hand = 2;
        this.head = 2;
        //Animal();    //Cannot call here, you must call it first at this constructor
    }

    Animal(int foot, int hand) {
        /*
            If you wanna call another constructor like Animal(), you must call it at the first statement in this constructor.
            You must user this() to call it, but not Animal().
        */
        this();
        //Animal();    //Cannot user Animal(), user this()
        this.foot = foot;
        this.hand = hand;
    }
    Animal() {
        this.head = 1;
    }
}

public class constructor_call_another_constructor {
    public static void main(String[] argv) {
        Animal monstor = new Animal(9, 6);
        System.out.println("It's " + monstor.head + " head");
    }
}
