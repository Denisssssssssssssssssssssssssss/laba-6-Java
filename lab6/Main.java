import classes.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Meleeweapon AA = new Meleeweapon(50);
        Firearms BB = new Firearms(50);
        System.out.println("\n" + AA.toString() + "\n");
        System.out.println("\n" + BB.toString() + "\n");
    }
}