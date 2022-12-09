package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Equipment {

    //поля класса
    private String eqtitle; //наименование снаряжения
    private int eqcost; //стоимость снаряжения


    //конструктор со всеми параметрами
    public Equipment(String eqtitle, int eqcost){
        this.eqtitle = eqtitle;
        if(eqcost >= 0)
            this.eqcost = eqcost;
        else {
            System.out.println("Указано недопустимое значение eqcost (eqcost < 0).");
            this.eqcost = 0;
        }
    }

    //конструктор с одним параметром
    public Equipment(int allfields){
        if(allfields >= 0) {
            eqtitle = Integer.toString(allfields);
            eqcost = allfields;
        }
        else{
            System.out.println("Указано недопустимое значение allfields (allfields < 0).");
            eqcost = 0;
            eqtitle = "";
        }
    }

    //конструктор без параметров
    public Equipment(){
        eqtitle = "";
        eqcost = 0;
    }

    //метод ввода класса
    public void input(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите наименование снаряжения: ");
        eqtitle = inp.nextLine();
        System.out.println("Введите стоимость снаряжения: ");
        eqcost = inp.nextInt();
    }

    //метод вывода класса
    public void output(){
        System.out.println("Снаряжение: " + eqtitle);
        System.out.println("Стоимость снаряжения: " + eqcost);
    }

    //метод возвращающий значение eqcost
    public int geteqcost(){return eqcost;}
}

    /** Метод записи в файл **/
    public void tofile(File file){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(eqtitle + "\n");
            pw.write(eqcost + "\n");
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
            eqitle = sc.nextLine();
            eqcost = Integer.parseInt(sc.nextLine());
            subs.getfromfile(file, sc);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}