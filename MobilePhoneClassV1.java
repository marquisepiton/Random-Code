//JAVA

package com.company;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MobilePhone {
    //fields
    private String phoneType;
    private String nameOfPhone;
    private String version;
    private String phoneNumber;
    //Where the contacts will be stored
    private ArrayList<String> contacts = new ArrayList<>();
    //Check if the phone is on or not.
    private boolean turnON = false;
    //Check for user input.
    private Scanner userInput = new Scanner(System.in);


    //Constructor
    public MobilePhone(String phoneType, String nameOfPhone, String version, String phoneNumber) {
        this.phoneType = phoneType;
        this.nameOfPhone = nameOfPhone;
        this.version = version;
        this.phoneNumber = phoneNumber;
    }
    //Methods
    //TurnOn() Must be called first before any other method is called.
    public void TurnOn(){
        if(!this.turnON){
            this.turnON = true;
            System.out.println("WELCOME!!!");
        }else{
            System.out.println("Phones is already on.");
        }
    }

    //1
    //Add a new contact name to ArrayList "contacts".
    public void addContact(){
        if(!this.turnON){
            System.out.println(".........Phone not on.");
        }else{
            System.out.println("Please enter the name you want to add");
            System.out.println("---------------------------------------");
            System.out.println("List of contacts already saved:");
            showList();
            System.out.println("Enter Here:");
            String contactName = userInput.next().toLowerCase();
            if(contacts.contains(contactName.toLowerCase())){
                System.out.println("Name is already in Contact.");
            }else{
                contacts.add(contactName);
                System.out.println(contactName + " is added to the list.");
                System.out.println("---------------------------------------");
            }
        }
    }
    //2
    //Removes a contact name from ArrayList "contacts".
    public void removeContact(){
        String contactName;

        if(!this.turnON){
            System.out.println(".........Phone not on.");
        }else{
            System.out.println("Please type contact name");
            System.out.println("---------------------------------------");
            System.out.println("List of contacts already saved:");
            showList();
            System.out.print("Enter name here: ");
            contactName = userInput.next().toLowerCase();
            if(!contacts.contains(contactName.toLowerCase())){
                System.out.println("Contact is not in the list.");
            }else{
                contacts.remove(contactName);
                System.out.println("Name removed");
                System.out.println("---------------------------------------");
            }
        }
    }
    //3
    //Modifies existing contact name.
    public void modifyContact(){
        String input;
        String changeUserNameinput;

        if(!this.turnON){
            System.out.println(".........Phone not on.");
        }else{

            System.out.print("Which user you would like to change?: ");
            input = userInput.next().toLowerCase();
            if(!contacts.contains(input.toLowerCase())){
                System.out.println("User is not on the list");
                System.out.println("---------------------------------------");
            }else{

                System.out.println("Put in the replacement name here:");
                changeUserNameinput = userInput.next().toLowerCase();
                contacts.set(contacts.indexOf(input),changeUserNameinput);
                System.out.println(input+ " is now " + changeUserNameinput + " have been changed.");
                System.out.println("---------------------------------------");
            }
        }
    }
    //4
    //Show the list of contacts
    public void showList(){
        if(contacts.size() == 0){
            System.out.println("---------------------------------------");
            System.out.println("No Contacts.");
        }else{
            for(String names: contacts){
                System.out.println(names);
                System.out.println("---------------------------------------");
            }
        }
    }
    //5
    //Prints out the Instructions again.
    public void printInstructions(){
        int buttonChoices;

        if(!this.turnON){
            System.out.println(".........Phone not on.");
        }else {
            // "Try" will check user input to see if it's invalid.
            try {
                while (this.turnON) {
                    System.out.println("#1 - Add a new contact.");
                    System.out.println("#2 - Remove a contact.");
                    System.out.println("#3 - Modify/Update existing contact.");
                    System.out.println("#4 - Show contact list.");
                    System.out.println("#5 - print out the instructions again.");
                    System.out.println("#6 - Get phone information.");
                    System.out.println("#7 - Turn off phone.");
                    System.out.println("---------------------------------------");
                    System.out.print("Choose the options that are listed using the #:");


                    int input = userInput.nextInt();
                    buttonChoices = +input;
                    switch (buttonChoices) {
                        case 1:
                            addContact();
                            break;
                        case 2:
                            removeContact();
                            break;
                        case 3:
                            modifyContact();
                            break;
                        case 4:
                            showList();
                            break;
                        case 5:
                            printInstructions();
                            break;
                        case 6:
                            getPhoneInformation();
                            break;
                        case 7:
                            quitApplication();
                            break;
                        default:
                            System.out.println("ERROR: Oops!!!Sorry that number is not valid..");
                            System.out.println("Please input a number # from the list");
                            System.out.println("---------------------------------------------------");

                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("---------------------------------------------------");
                System.out.println("Sorry that's not a valid entry. Turning off phone");
                System.out.println("BYE BYE!!");
            }
        }
    }

    //6
    //Get information about the phones(The object/Instances).
    public void getPhoneInformation(){
        System.out.println("Phone type: " +this.phoneType);
        System.out.println("Phone name:"+ this.nameOfPhone );
        System.out.println("Version:" + this.version );
        System.out.println("Phone #:" + this.phoneNumber);
    }
    //7
    //Quits the program, Turns off phone.
    public void quitApplication(){
        if(this.turnON) {
            this.turnON = false;
            System.out.println("Bye! Bye!");
            System.out.println("Phone is off...........");

        }
    }
}
