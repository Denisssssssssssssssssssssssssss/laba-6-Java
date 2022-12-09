package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Weapon {

    //поля класса
    private String weptitle; //наименование вооружения
    private int wepcost; //стоимость вооружения


    //конструктор со всеми параметрами
    public Weapon(String weptitle, int wepcost){
        this.weptitle = weptitle;
        this.wepcost = wepcost;
    }

    //конструктор с одним параметром
    public Weapon(int allfields){
        if(allfields >= 0) {
            weptitle = Integer.toString(allfields);
            wepcost = allfields;
        }
        else{
            System.out.println("Указано недопустимое значение allfields (allfields < 0).");
            weptitle = "";
            wepcost = 0;
        }
    }

    //конструктор без параметров
    public Weapon(){
        weptitle = "";
        wepcost = 0;
    }

    //метод ввода класса
    public void input(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите тип вооружения: ");
        weptitle = inp.nextLine();
        System.out.println("Введите затраты на вооружение: ");
        wepcost = inp.nextInt();
    }

    //метод вывода класса
    public void output(){
        System.out.println("Вооружение: " + weptitle);
        System.out.println("Стоимость вооружения: " + wepcost);
    }

    public int getwepcost(){return wepcost;}
    /** Метод записи в файл **/
    public void tofile(File file){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(weptitle + "\n");
            pw.write(wepcost + "\n");
            pw.close();
            subs.tofile(file);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /** Метод записи из файла **/
    public void getfromfile(File file, Scanner sc){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            weptitle = sc.nextLine();
            wepcost = Integer.parseInt(sc.nextLine());
            subs.getfromfile(file, sc);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
