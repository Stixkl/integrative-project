package ui;
import model.Date;
import model.Agenda;
import model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private BufferedReader reader;
    private Agenda controller;

    public Main() {
        controller = new Agenda();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }
    public static void main(String[] args) {
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
        boolean flag = false;

        while (!flag) {

            System.out.println("Please, select option do you want to do: ");

            System.out.println("1. Add Task");
            System.out.println("2. Modify Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Add Reminder");
            System.out.println("5. Modify Reminder");
            System.out.println("6. Delete reminder");
            System.out.println("7. Undo method");
            System.out.println("0. Salir");

            String optionMenuStr = reader.readLine();

            int optionMenu = Integer.parseInt(optionMenuStr);

            switch (optionMenu) {
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
                    flag = true;
                    reader.close();
                    break;
            }
        }
    }

    private void addTask() throws IOException{
        boolean flag = true;
        String title = "Default_Title";
        while (flag) {
            System.out.println("Introduce task´s title");
            title = reader.readLine();
            if (title.length() > 30) {
                System.out.println("Task title must be less than 30 characters");
            } else {
                flag = false;
            }
        }
        System.out.println("Introduce task´s description: ");
        String description = reader.readLine();
        System.out.println("Introduce task date (DD/MM/YYYY format): ");
        String dayStr = reader.readLine();
        int day = Integer.parseInt(dayStr);
        String monthStr = reader.readLine();
        int month = Integer.parseInt(monthStr);
        String yearStr = reader.readLine();
        int year = Integer.parseInt(yearStr);
        Date date = new Date(day,month,year);
        if(controller.addTasks(title, description, date)){
            System.out.println("Task added successfully");
        } else{
            System.out.println("Task not added");
        }
    }

    private void modifyTask(){
        System.out.println(controller.printTaskList());
    }

    private void deleteTask(){

    }

    private void addReminder() throws IOException{
        boolean flag = true;
        String title = "Default_Title";
        while (flag) {
            System.out.println("Introduce reminder´s title");
            title = reader.readLine();
            if (title.length() > 30) {
                System.out.println("Reminder title must be less than 30 characters");
            } else {
                flag = false;
            }
        }
        System.out.println("Introduce reminder´s description: ");
        String description = reader.readLine();
        System.out.println("Introduce reminder date (DD/MM/YYYY format): ");
        String dayStr = reader.readLine();
        int day = Integer.parseInt(dayStr);
        String monthStr = reader.readLine();
        int month = Integer.parseInt(monthStr);
        String yearStr = reader.readLine();
        int year = Integer.parseInt(yearStr);
        Date date = new Date(day,month,year);
        System.out.println(controller.addReminder(title, description, date));
    }

    private void modifyReminder(){

    }


    private void deleteReminder(){

    }

    private void undoMethod(){

    }
}
