package com.game;

 class  GameUI{

    final static String PURPLE ="\u001B[35m";
    final static String CYAN  ="\u001B[36m";
    final static String GREEN ="\u001B[32m";
    final static String RED    ="\u001B[31m";
    final static String YELLOW  ="\u001B[33m";
    final static String RESET ="\u001B[0m";


    static void typewriter(String text, int delay) throws InterruptedException {
        for(char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    static void LoadingBar() throws InterruptedException {
        for (int i = 0; i <= 20; i++) {
            System.out.print("\r" + GREEN + "Loading: ["
                    + new String(new char[i]).replace("\0", "=")
                    + new String(new char[20 - i]).replace("\0", " ")
                    + "] " + (i * 5) + "%" + RESET);

            Thread.sleep(100);
        }
        System.out.println("\n");
    }


    static void startCountdown(int sec) throws InterruptedException {
        for(int i = sec; i > 0; i--){
            System.out.println("\r" + CYAN + "Starting round in:" + YELLOW + i +"s" + RESET);
            Thread.sleep(1000);
        }
        System.out.println("\n");
    }

    static void animateGameOver(String art) throws InterruptedException {
        String[] glow = { RED, PURPLE, CYAN};

        for(int i=0; i<6; i++){
            System.out.print("\r" + glow[i % glow.length] + art + RESET);
            Thread.sleep(250);
        }
    }

    public static void showIntroUI() throws Exception{

        String header=
                "╔═══════════════════════════════════════╗\n" +
                        "║             SWIFTBOT SIMON GAME       ║\n" +
                        "╚═══════════════════════════════════════╝\n";

        for (char ch: header.toCharArray()) {
            System.out.print(PURPLE + ch + RESET);
            Thread.sleep(5);
        }

        typewriter(GREEN + "\n WELCOME, Champ! Get ready..." + RESET, 25);
        LoadingBar();
        startCountdown(3);
    }

    public static void GameOverAnim() throws InterruptedException {
        String art =
                "\n███████╗ █████╗ ███╗   ███╗███████╗   ██████╗ ██╗   ██╗███████╗██████╗\n" +
                        "██╔════╝██╔══██╗████╗ ████║██╔════╝     ██╔══██╗██║   ██║██╔════╝██╔══██╗\n" +
                        "█████╗  ███████║██╔████╔██║█████╗       ██████╔╝██║   ██║█████╗  ██████╔╝\n" +
                        "██╔══╝  ██╔══██║██║╚██╔╝██║██╔══╝       ██╔══██╗██║   ██║██╔══╝  ██╔══██╗\n" +
                        "███████╗██║  ██║██║ ╚═╝ ██║███████╗     ██████╔╝╚██████╔╝███████╗██║  ██║\n" +
                        "╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝  ╚═════╝ ╚══════╝╚═╝  ╚═╝\n";

        animateGameOver(art);
        System.out.println(RED + "\n Game Over!" + RESET);
    }
}

