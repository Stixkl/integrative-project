package ui;
import exceptions.IlegalIndexSwitch;
import exceptions.ListIsNullException;
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
    public static void main(String[] args) throws ListIsNullException, StructureNullException, IOException {
        Main m = new Main();
        boolean flag = false;
        while (!flag) {
            try {
                m.menu();
            } catch (IOException e) {
                throw new IOException("Input Output Exception");
            } catch (StructureNullException e) {
                throw new StructureNullException();
            } catch (ListIsNullException e) {
                throw new ListIsNullException("The list is empty");
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid input");
            }
            flag = true;
        }
    }


    private void menu() throws IOException, StructureNullException, ListIsNullException, NumberFormatException {
        System.out.println("Welcome to the TASK AND REMINDER APP");
        System.out.println("******************************************************************");
        boolean flag = false;

        while (!flag) {

            System.out.println("Please select which option do you want to do: ");

            System.out.println("1. Add Task");
            System.out.println("2. Modify Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Undo method");
            System.out.println("5. Print Priority Task");
            System.out.println("6. Print No Priority Task");
            System.out.println("7. Print Hash Table");
            System.out.println("0. Salir");

            String optionMenuStr = reader.readLine();

            int optionMenu = Integer.parseInt(optionMenuStr);

            switch (optionMenu) {
                case 1:
                    try {
                        addTask();
                    } catch (IOException e) {
                        throw new IOException("Input Output Exception");
                    } catch (NumberFormatException a) {
                        throw new NumberFormatException("Invalid input");
                    } catch (StructureNullException e) {
                        throw new StructureNullException();
                    }
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
                case 5:
                    printPriory();
                    break;
                case 6:
                    printNoPriory();
                    break;
                case 7:
                    printHash();
                    break;
                case 0:
                    flag = true;
                    reader.close();
                    break;
            }
        }
    }

    private void addTask() throws IOException, StructureNullException, NumberFormatException {
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
            if (optionPri > 3 || optionPri < 0) {
                System.out.println("Invalid option");
            } else {
                System.out.println("Introduce task date (DD/MM/YYYY format): ");
                String dayStr = reader.readLine();
                int day = Integer.parseInt(dayStr);
                String monthStr = reader.readLine();
                int month = Integer.parseInt(monthStr);
                String yearStr = reader.readLine();
                int year = Integer.parseInt(yearStr);
                Date date = new Date(day, month, year);
                if (controller.addTasks(title, description, date, optionPri)) {
                    System.out.println("Task added successfully");
                } else {
                    System.out.println("Task not added");
                }
            }
    }

    private void printPriory(){
        System.out.println(controller.printPriorityHeap());
    }

    private void printNoPriory(){
        System.out.println(controller.printNoPriorityQueue());
    }

    private void printHash(){
        System.out.println(controller.printHashTable());
    }

    private void modifyTask() throws IOException {

        System.out.println("This is the new task list in HashTable (no order): ");
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
        if (optionInt > 4 || optionInt < 1) {
            System.out.println("Invalid option");
        } else {
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
            System.out.println(controller.printPriorityHeap());
        }
    }

    private void deleteTask() throws  IOException, ListIsNullException {
        System.out.println("Do you want to delete a priority task or a no priority task?");
        System.out.println("1. Priority task");
        System.out.println("2. No priority task");
        String optionStrNorP = reader.readLine();
        int optionInt = Integer.parseInt(optionStrNorP);

        if(optionInt == 1){
            System.out.println(controller.deletePriority());
            System.out.println("This is the new Priority task list: ");
            System.out.println(controller.printPriorityHeap());
        } else if(optionInt == 2){
            System.out.println(controller.deleteNoPriority());
            System.out.println("This is the new No priority task list: ");
            System.out.println(controller.printNoPriorityQueue());
        } else{
            System.out.println("Invalid option");
        }
    }
    private void undoMethod() throws ListIsNullException {

        try{
            controller.undoMethod();
            System.out.println("This is the new No priority task list: ");
            System.out.println(controller.printNoPriorityQueue());
            System.out.println("This is the new Priority task list: ");
            System.out.println(controller.printPriorityHeap());
        } catch (ListIsNullException e) {
            System.out.println("There is no more actions to undo");
        }

    }
}
