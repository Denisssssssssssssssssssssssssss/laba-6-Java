package classes;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Employee {
    //поля класса
    private static int counter = 0; //счетчик количества сотрудников
    private int  id; //индивидуальный номер
    private Transport transport; //транспорт
    private Equipment equipment; //оборудование
    private Jobtitle jobtitle; //должность
    private Weapon weapon; //должность


    //конструктор класса со всеми параметрами
    public Employee(Transport transport, Equipment equipment,  Jobtitle jobtitle, Weapon weapon){
        counter++;
        id = counter;
        this.transport = transport;
        this.equipment = equipment;
        this.jobtitle = jobtitle;
        this.weapon = weapon;
    }

    //конструктор класса с одним параметром
    public Employee(int allfields){
        counter++;
        id = counter;
        if(allfields >= 0) {
            transport = new Transport(allfields);
            equipment = new Equipment(allfields);
            jobtitle = new Jobtitle(allfields);
            weapon = new Weapon(allfields);
        }
        else{
            transport = new Transport();
            equipment = new Equipment();
            jobtitle = new Jobtitle();
            weapon = new Weapon();
        }
    }

    //конструктор класса без параметров
    public Employee(){
        counter++;
        id = counter;
        transport = new Transport();
        equipment = new Equipment();
        jobtitle = new Jobtitle();
        weapon = new Weapon();
    }

    //метод вывода
    public void output(){
        System.out.println("ID: " + id);
        transport.output();
        equipment.output();
        jobtitle.output();
        weapon.output();
    }

    //метод ввода
    public void input(){
        Scanner inp = new Scanner(System.in);
        transport.input();
        equipment.input();
        jobtitle.input();
        weapon.input();
    }

    //метод подсчета затрат
    public int empcost(){
        int cost = 0;
        cost += transport.gettrcost();
        cost += jobtitle.getmonthlycost();
        cost += equipment.geteqcost();
        cost += weapon.getwepcost();
        return cost;
    }

    //метод вывода счетчика количества сотрудников
    public static void printcounter(){
        System.out.println("Количество сотрудников: " + counter);
    }

    //метод уменьшения количества сотрудников
    public static void minuscounter(){
        counter--;
        System.out.println("Количество сотрудников уменьшено на 1.");
    }

    //метод уменьшения количества сотрудников на number
    public static void minuscounter(int number){
        int x = counter;
        counter = counter - number;
        System.out.println("Количество сотрудников уменьшено c " + x + " до " + counter);
    }

    public void editjtitle(String jtitle, String add){
        jobtitle.editjtitle(jtitle, add);
    }

    /** Метод записи в файл **/
    public void tofile(File file){
        try {
            checkfilename cf= new checkfilename();
            if(!cf.checkfileextension(file.getName()))
                throw new Exception("Использовано недопустимое расширение файла. Допустимое расширение: \".txt\".");
            FileWriter pw = new FileWriter(file, true);
            pw.write(counter + "\n");
            pw.write(id + "\n");
            pw.close();
            jobtitle.tofile(file);
            equipment.tofile(file);
            transport.tofile(file);
            weapon.tofile(file);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    /** Метод записи из файла **/
    public void getfromfile(File file, Scanner sc) {
        try {
            checkfilename cf = new checkfilename();
            if (!cf.checkfileextension(file.getName()))
                throw new Exception("\"Использовано недопустимое расширение файла. Допустимое расширение: \\\".txt\\\".\"");
            counter = Integer.parseInt(sc.nextLine());
            id = Integer.parseInt(sc.nextLine());
            jobtitle.getfromfile(file, sc);
            equipment.getfromfile(file, sc);
            transport.getfromfile(file, sc);
            weapon.getfromfile(file, sc);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}