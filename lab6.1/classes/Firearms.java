package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Firearms extends Weapon {
    private int range;

    public Firearms(){
        super();
        range = 0;
    }

    public Firearms(int allfields) {
        super(allfields);
        if(allfields >= 0)
            range = allfields;
        else
            range = 0;
    }

    public Firearms(string weptitle, int wepcost, int range){
        super(weptitle, wepcost);
        if(range >=0)
            this.range = range;
        else{
            System.out.println("Указано недопустимое значение range.");
            this.range = 0;
        }
    }

    /**метод вывода Firearms**/
    public void output() {
        super.output();
        System.out.println("Дальность поражения: " + range);
    }

    /**метод ввода**/
    public void input(){
        super.input();
        System.out.println("Введите дальность поражения: ");
        Scanner inp = new Scanner(System.in);
        range = inp.nextInt();
    }

    /**Определение абстрактного метода**/
    @Override
    public void tofile(File file) {
        try {
            checkfilename cf = new checkfilename();
            if (!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(range + "\n");
            pw.close();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getfromfile(File file, Scanner sc) {
        try {
            super.getfromfile(file, sc);
            range = Integer.parseInt(sc.nextLine());
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public String toString(){
        return super.toString() + "\n" +
                "range = " + range;
    }
}