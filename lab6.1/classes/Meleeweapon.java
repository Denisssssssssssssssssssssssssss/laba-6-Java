package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Meleeweapon extends Weapon {
    private String damage;

    public Firearms(){
        super();
        damage = "";
    }

    public Meleeweapon(int allfields) {
        super(allfields);
        if(allfields >= 0)
            damage = allfields;
        else
            damage = "";
    }

    public Meleeweapon(string weptitle, int wepcost, int damage){
        super(weptitle, wepcost);
        if(damage >=0)
            this.damage = damage;
        else{
            System.out.println("Указано недопустимое значение damage.");
            this.damage = 0;
        }
    }

    /**метод вывода Firearms**/
    public void output() {
        super.output();
        System.out.println("Дальность поражения: " + damage);
    }

    /**метод ввода**/
    public void input(){
        super.input();
        System.out.println("Введите дальность поражения: ");
        Scanner inp = new Scanner(System.in);
        damage = inp.nextLine();
    }

    /**Определение абстрактного метода**/
    @Override
    public void tofile(File file) {
        try {
            checkfilename cf = new checkfilename();
            if (!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(damage + "\n");
            pw.close();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getfromfile(File file, Scanner sc) {
        try {
            super.getfromfile(file, sc);
            damage = sc.nextLine();;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public String toString(){
        return super.toString() + "\n" +
                "damage = " + damage;
    }
}



