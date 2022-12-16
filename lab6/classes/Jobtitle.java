package classes;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Jobtitle implements Cloneable {

    //поля класса
    private String jtitle; //наименование должности
    private int monthlycost; //стоимость месяца работы


    //конструктор со всеми параметрами
    public Jobtitle(String jtitle, int monthlycost){
        this.jtitle = jtitle;
        if(monthlycost >= 0)
            this.monthlycost = monthlycost;
        else{
            System.out.println("Указано недопустимое значение monthlycost (monthlycost < 0).");
            this.monthlycost = 0;
        }
    }

    //конструктор с одним параметром
    public Jobtitle(int allfields){
        if(allfields >= 0) {
            jtitle = Integer.toString(allfields);
            monthlycost = allfields;
        }
        else{
            System.out.println("Указано недопустимое значение allfields (allfields < 0).");
            jtitle = "";
            monthlycost = 0;
        }
    }

    /** Метод установки значений **/
    public void set(Jobtitle j){
        this.jtitle = j.jtitle;
        this.monthlycost = j.monthlycost;
    }


    //конструктор без параметров
    public Jobtitle(){
        jtitle = "";
        monthlycost = 0;
    }

    //метод ввода класса
    public void input(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите должность: ");
        jtitle = inp.nextLine();
        System.out.println("Введите стоимость месяца работы: ");
        monthlycost = inp.nextInt();
    }

    //метод вывода класса
    public void output(){
        System.out.println("Должность: " + jtitle);
        System.out.println("Стоимость месяца работы: " + monthlycost);
    }
    //метод возвращения значения
    public int getmonthlycost(){return monthlycost;}

    //метод для редактирования должности
    public void editjtitle(String jtitle, String add){
        StringBuilder sb = new StringBuilder();
        String[] words = this.jtitle.split(" ");
        this.jtitle = "";
        for(String word : words) {
            if(word.equals(jtitle)) {
                sb.append(add);
                sb.append(" ");
            }
            sb.append(word);
            sb.append(" ");
        }
        this.jtitle = sb.toString();
    }

    public void tofile(File file){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(jtitle + "\n");
            pw.write(monthlycost + "\n");
            pw.close();

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
            jtitle = sc.nextLine();
            monthlycost = Integer.parseInt(sc.nextLine());

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepclone() throws CloneNotSupportedException {
        Jobtitle jt = (Jobtitle) super.clone();
        return jt;
    }
}