package org.example;

import java.util.Scanner;

/*
 *   UCF COP 3330 Fall 2021 Assignment 20 Solution
 *   Copyright 2021 Donovan Reynolds
 */
public class App 
{
    public static void main( String[] args )
    {
        double order = stringToDouble("What is the order amount?");
        String state = inputOutput("What state do you live in?");
        double tax = Math.ceil(stateCheck(state)*100*order)/100;
        String finalText = "";
        double total = order + tax;

        if (tax != 0)
        {
            finalText = String.format("The tax is $%.2f\n",tax);
        }
        finalText += String.format("The total is $%.2f",total);

        System.out.println(finalText);

    }
    public static String inputOutput(String textToSay)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(textToSay);
        return input.nextLine();
    }

    public static int stringToInt(String text, String error)
    {
        int temp = 0;
        boolean check = false;
        while(!check)
        {
            try
            {
                temp = Integer.parseInt(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");
                text = inputOutput(error);

            }
        }
        return temp;
    }

    public static double stringToDouble (String error)
    {
        double temp = 0.0;
        boolean check = false;
        while(!check)
        {
             String text = inputOutput(error);
            try
            {
                temp = Double.parseDouble(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");

            }
        }
        return temp;
    }

    public static double stateCheck(String input)
    {
        double tax = .05;
        if (input.equals("Wisconsin"))
        {
              tax += county(inputOutput("What county do you live in?"));
        }
        else if (input.equals("Illinois"))
        {
            tax += .03;
        }
        else
        {
            return 0;
        }

        return tax;
    }

    public static double county(String input)
    {
        if (input.equals("Eau Claire"))
        {
            return .005;
        }
        else if(input.equals("Dunn"))
        {
            return .004;
        }
        return 0;
    }

}
