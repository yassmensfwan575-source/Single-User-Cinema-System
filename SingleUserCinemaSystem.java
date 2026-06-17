
import java.util.Scanner;

public class SingleUserCinemaSystem {
    // to print the menu

    static public void menu() {
        System.out.println("==========================================");
        System.out.println("\t**THE MENU**");
        System.out.println("1-View Seat Status.");
        System.out.println("2-Reserve a Seat.");
        System.out.println("3-Cancel a Reservation.");
        System.out.println("4-Show Last 3 Actions.");
        System.out.println("5-Change password.");
        System.out.println("6-Exit.");
        System.out.println("-----------------------------------------");
        System.out.print("Enter your choice:");
    }

    /*printing the returning menu which ask the user 
    if s/he want to return or exit*/
    static public void returningMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("1-Return to the menu.");
            System.out.println("2-Exit.");
            System.out.println("-----------------------------------------");
            System.out.print("Enter your choice: ");
            int case1Choice = in.nextInt();
            if (case1Choice == 1) {
                break;
            } else if (case1Choice == 2) {
                System.exit(0);
            } else {
                System.out.println("-----------------------------------------");
                System.out.println("Invalide choice!");
            }
        }
    }

    static public void viewSeats(String s1, String s2, String s3) {
        System.out.println("-----------------------------------------");
        System.out.println("Seat1: " + s1);
        System.out.println("Seat2: " + s2);
        System.out.println("Seat3: " + s3);
        returningMenu();

    }

    static public boolean authenticateUser(String acctualPIN) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the password: ");
        String PIN = in.next();

        if (acctualPIN.equals(PIN)) {
            return true;
        }
        int attempt = 0;
        while (attempt < 4) {
            System.out.println("-----------------------------------------");
            System.out.println("WRONG PASSWORD");
            System.out.print("Try again: ");
            PIN = in.next();
            if (acctualPIN.equals(PIN)) {
                return true;
            }

            attempt++;
        }
        //avoiding an error
        return false;
    }

    //to check the validity of the seat number
    // return true if valid ,false if not valid
    static public boolean seatNumberChecking(int seatNumber) {
        if (seatNumber <= 3 && seatNumber >= 1) {
            return true;
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("INVALID Seat Number!");
            return false;
        }
    }
    
    //checking that the new PIN is not letters
    static public boolean PIN_Checking(String PIN){
        for (int i = 0; i < PIN.length(); i++) {
            if(PIN.charAt(i)>='0'&&PIN.charAt(i)<='9'){
                //all numbers
            }else{
                //including letters
                return false;
            }
        }
        return true;
    }

    static public String changePIN(String actualPIN, String PIN) {
        Scanner in = new Scanner(System.in);
        if (PIN.equals(actualPIN)) {
            String newPIN;
            do {
                System.out.println("-----------------------------------------");
                System.out.println("Please make sure that: ");
                System.out.println("1-The new PIN is different from the old PIN.");
                System.out.println("2-The new PIN is a 4-digit PIN.");
                System.out.println("3-The new PIN doesn't include a letters.");
                System.out.println("-----------------------------------------");
                System.out.print("Enter the new PIN: ");
                newPIN = in.next();
            } while (newPIN.length() != 4 || newPIN.equals(actualPIN)||!PIN_Checking(newPIN));
            System.out.println("-----------------------------------------");
            System.out.println("Successfully changed.");
            return newPIN;
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("INCORRECT PIN, Can't change.");
            return "Fails";
        }
    }

    static public String cancelSeat(int seatNumber) {
        System.out.println("-----------------------------------------");
        System.out.println("Successfuly Canceled.");
        return "Empty";

    }

    static public String reserveSeat(int seatNumber) {
        Scanner in = new Scanner(System.in);
        String name;
        switch (seatNumber) {
            case 1:
                System.out.print("Enter your name to reserve:");
                name = in.nextLine();
                System.out.println("-----------------------------------------");
                System.out.println("Successfuly Reserved.");
                return "reserved for " + name +".";
            case 2:
                System.out.print("Enter your name to reserve:");
                name = in.nextLine();
                System.out.println("-----------------------------------------");
                System.out.println("Successfuly Reserved.");
                return "reserved for " + name +".";
            case 3:
                System.out.print("Enter your name to reserve:");
                name = in.nextLine();
                System.out.println("-----------------------------------------");
                System.out.println("Successfuly Reserved.");
                return "reserved for " + name +".";
        }
        //avoiding an error.
        return null;
    }

    // to check whether the seat is empty or not
    //return true if empty ,false if not empty
    static public boolean seatChecking(int seatNumber, String s1, String s2, String s3) {
        switch (seatNumber) {
            case 1:
                if (s1.equals("Empty")) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (s2.equals("Empty")) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (s3.equals("Empty")) {
                    return true;
                } else {
                    return false;
                }
        }
        //avoiding an error.
        return false;
    }

    static public void printLastThreeActions(String a1, String a2, String a3) {
        System.out.println("-----------------------------------------");
        System.out.println("1- " + a3);
        System.out.println("2- " + a2);
        System.out.println("3- " + a1);
        returningMenu();
    }

    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //declareing
        String actualPIN = "0000";
        String seat1 = "Empty";
        String seat2 = "Empty";
        String seat3 = "Empty";
        String last1 = "";
        String last2 = "no action yet.";
        String last3 = "";
        String newAction = "";// to trace the actions.

        //asking for the password
        if (authenticateUser(actualPIN)) {//true
            while (true) {
                //printing the menu in a loop
                menu();
                int seatNumber;
                int menuChoice = in.nextInt();
                switch (menuChoice) {
                    case 1:
                        viewSeats(seat1, seat2, seat3);
                        newAction = "Viewed seat status.";
                        break;
                    case 2:
                        System.out.println("This is a 3-seat cinema.");
                        System.out.print("Enter the seat number: ");
                        seatNumber = in.nextInt();
                        if (seatNumberChecking(seatNumber)) {//true
                            if (seatChecking(seatNumber, seat1, seat2, seat3)) {//true
                                switch (seatNumber) {
                                    case 1:
                                        seat1 = reserveSeat(seatNumber);
                                        newAction = "Reserved seat 1.";
                                        break;
                                    case 2:
                                        seat2 = reserveSeat(seatNumber);
                                        newAction = "Reserved seat 2.";
                                        break;
                                    case 3:
                                        seat3 = reserveSeat(seatNumber);
                                        newAction = "Reserved seat 3.";
                                        break;
                                }
                            } else {
                                System.out.println("-----------------------------------------");
                                System.out.println("Can't reserve a reserved seat.");
                                newAction = "";
                            }
                        } else {
                            newAction = "";
                        }
                        break;
                    case 3:
                        System.out.println("This is a 3-seat cinema.");
                        System.out.print("Enter the seat number: ");
                        seatNumber = in.nextInt();
                        if (seatNumberChecking(seatNumber)) {//true

                            if (seatChecking(seatNumber, seat1, seat2, seat3)) {//true
                                System.out.println("-----------------------------------------");
                                System.out.println("Can't cancel an unreserved seat.");
                                newAction = "";
                            } else {//false
                                switch (seatNumber) {
                                    case 1:
                                        seat1 = cancelSeat(seatNumber);
                                        newAction = "Canceled seat 1.";
                                        break;
                                    case 2:
                                        seat2 = cancelSeat(seatNumber);
                                        newAction = "Canceled seat 2.";
                                        break;
                                    case 3:
                                        seat3 = cancelSeat(seatNumber);
                                        newAction = "Canceled seat 3.";
                                        break;
                                }
                            }
                        } else {
                            newAction = "";
                        }
                        break;
                    case 4:
                        printLastThreeActions(last1, last2, last3);
                        newAction = "Showed the last 3 actions.";
                        break;
                    case 5:
                        System.out.print("Enter the current PIN: ");
                        String currentPIN = in.next();
                        String temp = changePIN(actualPIN, currentPIN);
                        if (temp.equals("Fails")) {
                            newAction = "";
                        } else {
                            actualPIN = temp;
                            newAction = "Changed PIN";
                        }
                        break;
                    case 6:
                        System.out.println("Exiting....");
                        System.exit(0);
                    default:
                        System.out.println("-----------------------------------------");
                        System.out.println("Invalid choice!");
                }
                /*swaping excpt if newAction ="" 
                which mean there is a failed action*/
                if (!"".equals(newAction)) {
                    last1 = last2;
                    last2 = last3;
                    last3 = newAction;
                }

            }
        } else {//false
            System.out.println("SORRY,YOU HAVE EXCEEDED ALL OF YOUR ATTEMPTS!");
        }

    }
}
