/**This program calculates the BMI of an individual from the controlled input of
 * mass and height entered by he user. Input can either be entered in pounds/inches
 * or kilograms/meters. Source code written by Awunjia Serge Atabong in Buea-cameroon
 * on the 17/08/2020, contact me directly at awujiaa2018@gmail.com whatsApp: +237 651565843.
 * This is a free and open source sofware(FOSS), feel free to modify accordingly and use.
 */

package com.ASAtech;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//main class
public class Main {

    //Declaring private fields
    private static final double INDEX = 703;
    private static double height;
    private static double mass;
    private static double BMI;

    //Declaring scanner object for input
    private static Scanner read = new Scanner(System.in);

    //Declaring method to calculate bmi in pounds/inches
    public static double bmiPounds(double m, double h){
        BMI = (m * INDEX) / (h * h);
        return BMI;
    }

    //Declaring method to calculate bmi in kilometers/meters
    public static double bmiKilograms(double m, double h){
        BMI = m / (h * h);
        return BMI;
    }

    //Declaring method to display result according to the bmi value
    public static void checkBMI(double bmi){
        if(bmi < 18.5){
            System.out.printf("Status: Underweight\nValue: %.2f", bmi);
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            System.out.printf("Status: Normal\nValue: %.2f", bmi);
        }
        else if(bmi >= 25 && bmi <= 29.9){
            System.out.printf("Status: Overweight\nValue: %.2f", bmi);
        }
        else{
            System.out.printf("Status: Obese\nValue: %.2f", bmi);
        }


    }

    //Main method
    public static void main(String[] args) throws InterruptedException {

        double mTmp, hTmp;
        int opt, tmp;
        System.out.println("\n\nWelcome to the National Institutes of Health\n" +
                           "*********************************************");
        System.out.println("Please select the measurement unit for BMI;\n");
        System.out.println("1 -> Weight(pounds), Height(inches).");
        System.out.println("2 -> Weight(Kilograms), Height(meters).");

        //Break loop only when input is within range
        while(true){
            tmp = read.nextInt();
            if(tmp == 1 || tmp == 2){
                opt = tmp;
                break;
            }
            else{
                System.out.println("Invalid Input! Enter 1 or 2!");
            }
        }

        //Run distinct codes accordimg to the option choosen by th user
        if(opt == 1) {
            while (true) {
                System.out.println("Enter Mass:");
                mTmp = read.nextDouble();
                if (mTmp > 0 && mTmp < 1544) {
                    mass = mTmp;
                    break;
                } else {
                    System.out.println("Mass value out of range!");
                }
            }
            while (true) {
                System.out.println("Enter Height:");
                hTmp = read.nextDouble();
                if (hTmp > 0 && hTmp < 119) {
                    height = hTmp;
                    break;
                } else {
                    System.out.println("Height value out of range!");
                }
            }
        }
        else{
            while(true) {
                System.out.println("Enter Mass:");
                mTmp = read.nextDouble();
                if(mTmp > 0 && mTmp < 700){
                    mass = mTmp;
                    break;
                }
                else{
                    System.out.println("Mass value out of range!");
                }
            }

            while(true) {
                System.out.println("Enter Height:");
                hTmp = read.nextDouble();
                if(hTmp > 0 && hTmp < 3){
                    height = hTmp;
                    break;
                }
                else{
                    System.out.println("Height value out of range!");
                }
            }
        }

        //Compute BMI according the option choosen by user
        switch (opt){
            case 1:
                BMI = bmiPounds(mass, height);
                break;
            case 2:
                BMI = bmiKilograms(mass, height);
                break;
        }

        System.out.println("Computing...\n");
        TimeUnit.SECONDS.sleep(3);

        System.out.println("BMI RESULTS\n" +
                           "***********");
        checkBMI(BMI);
        System.out.println("\n");
    }

    //Open source is love
}

