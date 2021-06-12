package com.company;

import java.util.Scanner;

public class Main {
    private static MobilePhone mobilePhone = new MobilePhone();
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("***CONTACTS***");
        printMenu();
        int choice;
        boolean flag = true;
        while (flag){
            System.out.print("Select option:");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    addContact();
                    break;
                case 2:
                    deleteContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    printContatList();
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    System.out.println("Exiting Application...");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Try again..");
            }
        }
    }
    private static void printMenu(){
        System.out.println("Press 1 to add contact.");
        System.out.println("Press 2 to delete contact.");
        System.out.println("Press 3 to search contact.");
        System.out.println("Press 4 to update contact.");
        System.out.println("Press 5 to print contact list.");
        System.out.println("Press 6 to print instructions.");
        System.out.println("Press 7 quit application.");
    }
    private static void addContact(){
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scan.nextLine();
        Contacts newContact =  Contacts.createContact(name,phoneNumber);
        boolean status = mobilePhone.addContact(newContact);
    }
    private static void printContatList(){
        mobilePhone.printContactList();
    }
    private static void updateContact(){
        System.out.print("Enter name of the contact to be updated: ");
        String oldName = scan.nextLine();
        Contacts oldContact = mobilePhone.queryContact(oldName);
        if(oldContact==null){
            System.out.println("Contact not found.");
        } else {
            System.out.print("Enter new contact name: ");
            String name = scan.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNumber = scan.nextLine();
            Contacts newContact = Contacts.createContact(name,phoneNumber);
            mobilePhone.updateContact(oldContact,newContact);
        }
    }
    private static void searchContact(){
        System.out.print("Enter name of the contact to search: ");
        String name = scan.nextLine();
        Contacts contact = mobilePhone.queryContact(name);
        mobilePhone.searchContact(contact);
    }
    private static void deleteContact(){
        System.out.println("Enter name of the contact");
        String name = scan.nextLine();
        Contacts contact = mobilePhone.queryContact(name);
        mobilePhone.removeContact(contact);
    }
}
