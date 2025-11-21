package com.game;

import swiftbot.SwiftBotAPI;

public class Main {


    static SwiftBotAPI swiftBot;

    public static void main(String[] args) throws InterruptedException {

        try {
            swiftBot = SwiftBotAPI.INSTANCE;
        } catch (Exception e) {
            System.out.println("\nI2C disabled!");
            System.exit(5);
        }
    }
}

