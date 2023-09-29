package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private BufferedReader reader;

    public Main() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    public static void main(String[] args) {
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Por favor, introduce una línea de texto: ");
            String linea = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        Main m = new Main();
        try {
            m.menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void menu() throws IOException {

        System.out.println("Welcome to the TASK AND REMINDER APP");
        System.out.println("******************************************************************");

        boolean flag=false;

        while (!flag){

            System.out.println("Please, select option do you want to do: ");

            System.out.println("1. Add Task");
            System.out.println("2. Modify Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Add Reminder");
            System.out.println("5. Modify Reminder");
            System.out.println("6. Delete reminder");
            System.out.println("7. Undo method");
            System.out.println("0. Salir");

            int optionMenu = reader.read();

            switch (optionMenu){
                default:
                    System.out.println("Index out of bounds, please type another one");
                    break;
                case 1:
                    addTask();
                    break;
                case 2:
                    modifyTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    addReminder();
                    break;
                case 5:
                    modifyReminder();
                    break;
                case 6:
                    deleteReminder();
                    break;
                case 7:
                    undoMethod();
                    break;
                case 0:
                    flag=true;
                    reader.close();
                    break;
            }
        }
    }

    private void addTask(){

    }

    private void modifyTask(){

    }

    private void deleteTask(){

    }

    private void addReminder(){

    }

    private void modifyReminder(){

    }


    private void deleteReminder(){

    }

    private void undoMethod(){

    }



}
