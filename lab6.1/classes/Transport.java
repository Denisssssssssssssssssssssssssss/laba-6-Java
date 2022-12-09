package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
public class Transport {

    //поля класса
    private String trtitle; //наименование должности
    private int trcost; //стоимость месяца работы


    //конструктор со всеми параметрами
    public Transport(String trtitle, int trcost){
        this.trtitle = trtitle;
        this.trcost = trcost;
    }

    //конструктор с одним параметром
    public Transport(int allfields){
        if(allfields >= 0) {
            trtitle = Integer.toString(allfields);
            trcost = allfields;
        }
        else{
            System.out.println("Указано недопустимое значение allfields (allfields < 0).");
            trtitle = "";
            trcost = 0;
        }
    }

    //конструктор без параметров
    public Transport(){
        trtitle = "";
        trcost = 0;
    }

    //метод ввода класса
    public void input(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите тип транспорта: ");
        trtitle = inp.nextLine();
        System.out.println("Введите затраты на траспорт: ");
        trcost = inp.nextInt();
    }

    //метод вывода класса
    public void output(){
        System.out.println("Транспорт: " + trtitle);
        System.out.println("Стоимость транспортировки: " + trcost);
    }

    public int gettrcost(){return trcost;}
}
    /** Метод записи в файл **/
    public void tofile(File file){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(trtitle + "\n");
            pw.write(trcost + "\n");
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
            trtitle = sc.nextLine();
            trcost = Integer.parseInt(sc.nextLine());
            subs.getfromfile(file, sc);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}