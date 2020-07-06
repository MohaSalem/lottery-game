package com.company;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class LotteryGame {

    private Random random = new Random();
    private final int winningGuess = random.nextInt(100001);
    private int moneyLost = 0;
    Scanner input = new Scanner(System.in);

    public LotteryGame() {
    }

    public void runGame() {
        try {
            System.out.println("You can win a million dollar! Guess and enter the winning number -a number between 0 and 100000-\n" +
                    "for '1.00'$ or insert 'Q' to quit the game!\n");
            String choice = input.next();
            switch (choice.toLowerCase()) {
                case "q":
                    System.out.println("You lost " + moneyLost + " dollars, thanks for playing. See you again!");
                    System.exit(0);
                    break;
                default:
                    moneyLost++;
                    int theGuess = Integer.valueOf(choice);
                    if (theGuess == winningGuess) {
                        System.out.println("YOU WON THE MILLION!");
                    } else {
                        System.out.println("Sorry! good guess, but not the right one. Do you want me to give you a hint for 2$ (Y / N) ?!");
                        String decision = input.next();
                        switch (decision.toLowerCase()) {
                            case "n":
                                runGame();
                                break;
                            default:
                                moneyLost = moneyLost + 2;
                                if (theGuess > winningGuess) {
                                    System.out.println("Your guess is higher, guess lower!");
                                    runGame();
                                    break;
                                } else {
                                    System.out.println("Your guess is lower, guess higher!");
                                    runGame();
                                    break;
                                }
                        }
                    }
            }
        } catch (Exception ex) {
            System.out.println("There is an error, enter the values as required numbers or characters!");
        } finally {
            runGame();
        }
    }
}