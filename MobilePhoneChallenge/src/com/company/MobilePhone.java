package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> myContacts ;

    public MobilePhone() {
        this.myContacts = new ArrayList<Contacts>();
    }
    public boolean addContact(Contacts contact){
        if(findContact(contact.getName())>=0){
            System.out.println("Contact is already present");
            return false;
        }
        System.out.println(contact.getName() + " added to the contact list.");
        myContacts.add(contact);
        return true;
    }
    private int findContact(Contacts contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String name){
        for(int i = 0; i < this.myContacts.size(); i++){
            Contacts contacts = this.myContacts.get(i);
            if(contacts.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public String queryContact(Contacts contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.myContacts.get(position);
        }
        return null;
    }
    public void updateContact(Contacts oldContact, Contacts newContact){
        if(findContact(oldContact)<0){
            System.out.println("Old contact not on file.");
        }
        System.out.println(oldContact.getName() + " replaced by " + newContact.getName());
        myContacts.set(findContact(oldContact),newContact);
    }
    public boolean removeContact(Contacts contact){
        if(findContact(contact)<0){
            System.out.println("Contact not on file.");
            return false;
        } else {
            System.out.println(contact.getName() + " removed from contact list.");
            myContacts.remove(contact);
            return true;
        }

    }
    public void printContactList(){
        for (int i = 0; i < this.myContacts.size(); i++){
            Contacts contact = myContacts.get(i);
            System.out.println((i+1)+ ".");
            System.out.println("\t Name: " + contact.getName());
            System.out.println("\t Phone Number: " + contact.getPhoneNumber());
        }
    }
    public boolean searchContact(Contacts contact){
        if(findContact(contact)>=0){
            System.out.println("Contact " + contact.getName() + " is on file." );
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone number: " + contact.getPhoneNumber());
            return true;
        } else {
            System.out.println("Contact not found.");
            return false;
        }
    }
}
