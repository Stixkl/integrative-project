package ui;
import exceptions.IlegalIndexSwitch;
import exceptions.StructureNullException;
import model.Date;
import model.Agenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        } catch (StructureNullException e) {
        }
    }


    private void menu() throws IOException, StructureNullException {
        System.out.println("Welcome to the TASK AND REMINDER APP");
        System.out.println("******************************************************************");
        boolean flag = false;

        while (!flag) {

            System.out.println("Please select which option do you want to do: ");

            System.out.println("1. Add Task");
            System.out.println("2. Modify Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Undo method");
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
                    undoMethod();
                    break;
                case 0:
                    flag = true;
                    reader.close();
                    break;
            }
        }
    }

    private void addTask() throws IOException, StructureNullException {

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

        System.out.println("Select task priority: ");
        System.out.println("3. High priority");
        System.out.println("2. Priority");
        System.out.println("1. Least priority");
        System.out.println("0. No priority");
        String optionPriority = reader.readLine();
        int optionPri = Integer.parseInt(optionPriority);

        System.out.println("Introduce task date (DD/MM/YYYY format): ");
        String dayStr = reader.readLine();
        int day = Integer.parseInt(dayStr);
        String monthStr = reader.readLine();
        int month = Integer.parseInt(monthStr);
        String yearStr = reader.readLine();
        int year = Integer.parseInt(yearStr);
        Date date = new Date(day,month,year);
        if(controller.addTasks(title, description, date, optionPri)){
            System.out.println("Task added successfully");
        } else{
            System.out.println("Task not added");
        }

    }

    private void modifyTask() throws IOException {

        System.out.println("This is the task list: ");
        System.out.println(controller.printHashTable());

        System.out.println("Insert the id of the task you want to modify: ");

        String idModifyStr = reader.readLine();
        int idModifyInt = Integer.parseInt(idModifyStr);

        System.out.println("Insert what you want to modify");
        System.out.println("1. Title");
        System.out.println("2. Description");
        System.out.println("3: Date");
        System.out.println("4. Priority");

        String optionString = reader.readLine();
        int optionInt = Integer.parseInt(optionString);

        switch (optionInt) {
            case 1:
                System.out.println("Insert the new title");
                String newTitle = reader.readLine();
                controller.modifyTask(newTitle, null, null, optionInt, idModifyInt, 0);
                break;
            case 2:
                System.out.println("Insert the new description");
                String newDescription = reader.readLine();
                controller.modifyTask(null, newDescription, null, optionInt, idModifyInt, 0);
                break;
            case 3:
                System.out.println("Insert the new date");

                System.out.println("Insert the day (dd)");
                String newDay = reader.readLine();
                int day = Integer.parseInt(newDay);
                System.out.println("Insert the month (mm)");
                String newMonth = reader.readLine();
                int month = Integer.parseInt(newMonth);
                System.out.println("Insert the year (yyyy)");
                String newYear = reader.readLine();
                int year = Integer.parseInt(newYear);
                Date date = new Date(day, month, year);
                controller.modifyTask(null, null, date, optionInt, idModifyInt, 0);
                break;
            case 4:
                System.out.println("Insert the new priority of the task");
                System.out.println("3. High priority");
                System.out.println("2. Priority");
                System.out.println("1. Least priority");
                System.out.println("0. No priority");
                String newPriorityStr = reader.readLine();
                int newPriorityInt = Integer.parseInt(newPriorityStr);
                controller.modifyTask(null, null, null, optionInt, idModifyInt, newPriorityInt);
                break;
            default:
                System.out.println("X");
                break;
        }
        System.out.println("This is the new No priority task list: ");
        System.out.println(controller.printNoPriorityQueue());
        System.out.println("This is the new Priority task list: ");
        controller.getPriorityTasks().buildMaxHeapify();
        System.out.println(controller.printPriorityHeap());
    }

    private void deleteTask(){

    }



    private void undoMethod(){

    }
}
