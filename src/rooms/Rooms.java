package rooms;

import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {

    static Scanner input = new Scanner(System.in);

    static String room1[];
    static String room2[];
    static String room3[];
    static String room4[];
    static String room5[];
    static int room;

    public static String folderDirectory;

    public static ArrayList<String> textItems = new ArrayList<>();
    private static ArrayList<booking> bookedrooms = new ArrayList<>();

    public static void getDir() {
        folderDirectory = System.getProperty("user.dir") + "//bookedrooms.txt";

    }

    public static void main(String[] args) {

        getDir();
        System.out.println("Your current file path is; " + folderDirectory);
//        writeFile();

        bookedrooms = filehandling.readFile();
        System.out.println("");
//        readFile();
//        printItems();

        room1 = new String[2];
        //2 people

        room2 = new String[4];
        //4 people

        room3 = new String[8];
        //8 people

        room4 = new String[15];
        //15 people

        room5 = new String[50];
        //50 people

        choice();
    }

    public static void choice() {

        System.out.println("");
        System.out.println("");
        System.out.println("What would you like to do");
        System.out.println("1) Book a room");
        System.out.println("2) Book resources for a room");
        System.out.println("3) View bookings");
        System.out.println("4) Done");

        int userchoice = input.nextInt();

        switch (userchoice) {
            case 1:
                Bookroom();
                break;

            case 2:
                readFile();
                printItems();
                break;
            case 0:
                filehandling.writeFile(bookedrooms);
                break;

            // code block
        }

    }

    public static void Bookroom() {
        int roomsava = 0;

        System.out.println("How many people is the room for?");
        System.out.println("Room 4 is the only room with wheelchair accessability, with a maximum of 15 people.");
        int peopnum = input.nextInt();

        if (peopnum <= room1.length) {
            roomsava = 5;
        } else {

            if (peopnum <= room2.length) {
                roomsava = 4;
            } else {
                if (peopnum <= room3.length) {
                    roomsava = 3;
                } else {
                    if (peopnum <= room4.length) {
                        roomsava = 2;
                    } else {
                        if (peopnum <= room5.length) {
                            roomsava = 1;
                        } else {
                            System.out.println("We don't have a room for you");
                        }
                    }
                }
            }
        }
        if (roomsava > 0) {

            System.out.println("we have " + roomsava + " avalible for use");
            System.out.print("Would you like room ");
            for (int i = 0; i < roomsava - 1; i++) {
                int j = i + 1;
                System.out.print(5 - j);
                System.out.print(" ");

            }
            if (roomsava != 1) {
                System.out.print("or ");
            }
            System.out.print("5");
            System.out.println("?");
            boolean done = false;
            while (done == false) {
                System.out.println("Booking room?");
                room = input.nextInt();
                System.out.println("");
                if ((room < 5 - roomsava) && (room > 0)) {
                    System.out.println("That room isn't availible.");
                    System.out.println("Please pick another.");
                } else {
                    if ((room >= roomsava) && (room < 6)) {
                        done = true;
                    }
                }
            }
            System.out.println("Enter name and booking time.");

            Scanner input = new Scanner(System.in);
            System.out.println("Name?");
            String name = input.nextLine();
            System.out.println("");
            System.out.println("Booking time?");
            String time = input.next();
            System.out.println("");
            System.out.println("Request?");
            String request = input.nextLine();
            System.out.println("");

            booking roombooking = new booking(name, time, room, request);
            bookedrooms.add(roombooking);

            System.out.println(roombooking.toString());


        }
        choice();
    }

    public static void readFile() {
        String inputLine;
        try {
            if (bookedrooms.isEmpty()) {
                System.out.println("Sorry, there are no books right now");
            } else {
                for (int i = 0; i < bookedrooms.size(); i++) {
                    System.out.println(bookedrooms.get(i).toString());
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void printItems() {
        for (int i = 0; i < textItems.size(); i++) {
            System.out.println(textItems.get(i));

        }
    }

}
