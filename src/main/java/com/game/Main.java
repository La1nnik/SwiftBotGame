package com.game;

import swiftbot.Button;
import swiftbot.SwiftBotAPI;
import swiftbot.Underlight;

import java.util.ArrayList;
import java.util.Random;

public class Main
{


    static void printScore(short round, short score)
    {
        System.out.println("\n\u001B[35m===============================\u001B[0m");
        System.out.println("\u001B[35m    \u001B[35mRound: \u001B[35m" + round + "       Score: " + score + "\u001B[35m   \u001B[0m");
        System.out.println("\u001B[35m===============================\u001B[0m\n");
    }

    static void changeStart(boolean start)
    {
        start = false;
    }


    static SwiftBotAPI swiftBot;

    public static void main(String[] args) throws InterruptedException
    {

        try
        {
            swiftBot = SwiftBotAPI.INSTANCE;
        }

        catch (Exception e)
        {
            System.out.println("\nI2C disabled!");
            System.exit(5);
        }

        /*

        255, 0, 0    // red
        0, 255, 0    // green
        0, 0, 255    // blue
        255, 255, 0  // yellow

         */


        short round = 1;
        short score = 0;


        printScore(round, score);
    /*
        for(int i = 3; i > 0; i--)
        {
            System.out.println("Staring game in: " + i + "s");
            Thread.sleep (1000);
        }
    */

        ArrayList<int[]> savedColors = new ArrayList<int[]>();
        ArrayList<Underlight> savedUnderlights = new ArrayList<>();

        boolean finish = false;
        while(finish)
        {

            final int[][] colors =
            {
                    {255, 0, 0}, // red
                    {0, 255, 0}, // green
                    {0, 0, 255}, // blue
                    {255, 255, 0} // yellow
            };

            Random rand = new Random();


            for(int i = 0; i < round; i++)
            {
                int randomNum = rand.nextInt(4);
                savedColors.add(colors[randomNum]);

                if(colors[randomNum][0] == 255 && colors[randomNum][1] == 0 )
                {
                    savedUnderlights.add(Underlight.FRONT_LEFT);
                }
                else if(colors[randomNum][0] == 0 && colors[randomNum][1] == 255 )
                {
                    savedUnderlights.add(Underlight.BACK_LEFT);
                }
                else if(colors[randomNum][0] == 0 && colors[randomNum][1] == 0 )
                {
                    savedUnderlights.add(Underlight.FRONT_RIGHT);
                }
                else
                {
                    savedUnderlights.add(Underlight.BACK_RIGHT);
                }

            }

        }


    }

}

