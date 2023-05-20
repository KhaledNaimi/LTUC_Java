/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.assignment_task1;

/**
 *
 * @author knaim
 */
import java.util.*;

public class Assignment_Task1 {
    //===================================================================================
    // Definition of Arrays :
    // vehicleName array : consists of a list of Vehicle Brand Names entered by user.
    // vehicleYear array : consists of a list of Vehicle Production Years enterd by user.
    // The index for a vehicle must have the same index in vehicleName and vehicleYear
    //===================================================================================

    static ArrayList<String> vehicleName = new ArrayList<String>();

    static ArrayList<Integer> vehicleYear = new ArrayList<Integer>();
//=======================================================================================
//The following method (CharCount) is a helper general method called from EnterVehicle method, to count number of a Character in a String
// in our case, this method is used to count the number of spaces between Vehicle Name and Vehicle Year entered by the user,
// because we need only ONE space between them to be able to seperate vehicle name and vehicle year.
//=================================================================================================================    

    public static int CharCount(char anyChar, String anyString) {
        // int i;
        int count = 0;
        for (int i = 0; i < anyString.length(); i++) {
            if (anyString.charAt(i) == anyChar) {
                count++;
            }
        }
        return count;
    }
//========================================================================================
// The following method EnterVehicle is a helper method called from Run method to enter the Vehicle name and the Vehicle year in one line with a single space between them .
// Then add the entered values to the arrays related for each part (vehicle name / vehicle year)
// ===========================================================================================

    static void EnterVehicle() {
        String vehicle;
        Scanner vehicleInput = new Scanner(System.in);
        System.out.println("please,Enter a vehicle name and vehicle year seperated by a single space , for example LEAF 2015");
        vehicle = (vehicleInput.nextLine()).trim();
        //int count =  Occurrence(' ', vehicle)>1;
        if (CharCount(' ', vehicle) > 1) {
            System.out.println("Use One Space in the vehicle data");
            return;
        }

        int i = vehicle.indexOf(" ");

        if (i >= 0) {
            String vName = vehicle.substring(0, i);
            String vYear = vehicle.substring(i + 1, vehicle.length());
            int vYear_int = Integer.parseInt(vYear);
            vehicleName.add(vName);
            vehicleYear.add(vYear_int);
        }
    }
//===========================================================================================================
// The following method (Run) method , is a master method called from the (main) method , where we manage the data entry and filling the arrays by helper methods called from Run method. 
//=====================================================================================================================    

    static void Run() {
        char addOption;
        System.out.println("Do you want to add a vehicle name ?, enter 1 for yes and 0 for no ");
        Scanner input = new Scanner(System.in);
//      DO-While loop to be sure the value either 1 or 0. 
        do {
            addOption = input.next().charAt(0);
        } while (addOption != '0' & addOption != '1');
        if (addOption == '0') {
            System.out.println("Program ended without entering vehicles");
            return;
        }
//     Call the EnterVehicle mothod to enter the first vehicle data and add to the arrays
        EnterVehicle();
        char optionToAdd;

//      Loop to continue adding Vehicle data until we stop by entering 0 option
        Scanner option = new Scanner(System.in);
        do {
            System.out.println("Enter 1 to continue , or 0 to stop adding vehicles");
            optionToAdd = option.next().charAt(0);
            if (optionToAdd != '1' & optionToAdd != '0') {
                System.out.println("Invalid Option");
            } else {
                if (optionToAdd == '1') {
                    EnterVehicle();
                } else {
                    System.out.println("vehicle addition stopped");
                    break;
                }
            }
        } while (true);
    }

//=========================================================================================================================== 
// The following method (searchForVehicleYear) is a master method called from the (main) method for searching a car of a specific year,
// the prarameter (year) passed from main method is the search criteria. As the array is not sorted , I used the Linear search , 
// where I go through the array items one by one until I find the matching item.
// If the vehicle year found , then the return value is a message contains vehicle year and vehicle name , 
// If not found , the return value is a message string indicating that the vehicle year not found.
//============================================================================================================================    
    static String searchForVehicleYear(int year) {
        String returnMsg;

        for (int i = 0; i <= vehicleYear.size() - 1; i++) {
            if (vehicleYear.get(i) == year) {
                returnMsg = "First vehicle found for year " + vehicleYear.get(i) + " is " + vehicleName.get(i);
                return returnMsg;
            }
        }
        return "there is no vehicle found for year " + year;

    }
//=================================================================================================================
//=================================================================================================================
// The follworing is the main method, this is the first method to execute and from this method we call other master and helper methods to perform our task.
// the master and helper methods have a description at the begining of each method.    
//
//==================================================================================================================    

    public static void main(String[] args) {

        String choice;
        Scanner input = new Scanner(System.in);
        // Do-While loop to input valid text ("yes" or "no")
        do {
            System.out.println("Do you want to start the program run ? (yes/no) ");
            choice = input.nextLine();
            // Check for the value entered 
            if (!choice.equalsIgnoreCase("yes") & !choice.equalsIgnoreCase("no")) {
                System.out.println("input error,please input vaild text");
            }
        } while (!choice.equalsIgnoreCase("yes") & !choice.equalsIgnoreCase("no"));

        if (choice.equalsIgnoreCase("no")) {
            System.out.println("*** Exit Program ***");
            return;
        }
        // Program Continues to the RUN() mothod
        System.out.println("*** Program Starts *** ");
        Run();

        if (!vehicleName.isEmpty()) {
            System.out.println("Whitch vehlicle year would you like to search? ");
            int vYear;
            vYear = input.nextInt();
            System.out.println(searchForVehicleYear(vYear));
            System.out.println("*** search ends sucessfully ***");
        }

    }
}
