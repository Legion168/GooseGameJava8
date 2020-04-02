import model.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class mainClass {
    private static void insertPlayer(List<Player> playerList) {
        boolean found;

        System.out.println("Insert player " + (playerList.size() + 1) + " name: ");

        do {
            Scanner scanner = new Scanner(System.in);

            String name = scanner.nextLine().trim();

            found = playerList.stream().anyMatch(p -> p.getUsername().equalsIgnoreCase(name));

            if (found) {
                System.out.println("Name already taken!\nPlease insert new one.");
            } else if (name.isEmpty()) {
                System.out.println("Name inserted is empty!\nPlease insert a valid name.");
                found = true;
            } else {
                playerList.add(new Player(name));
                System.out.println("\nPlayer " + name.toUpperCase() + " joined the game!");
            }
        } while (found);
    }

    private static void showPlayers(List<Player> playerList) {
        System.out.println("       PLAYERS     ");
        System.out.println("---------------------");

        if (playerList.size() > 0)
            playerList.forEach(System.out::println);
        else
            System.out.println("No player joined yet!");
    }

    private static void readOption() {
        int choice = 999;
        List<Player> playerList = new ArrayList<>();

        do {
            System.out.println("\nChoose what to do: \n");

            System.out.println("1) Add New Player");
            System.out.println("2) Show Signed Players");
            System.out.println("3) Start Game");
            System.out.println("4) Exit\n");

            do {
                Scanner in = new Scanner(System.in);
                try {
                    choice = in.nextInt();

                    if (choice > 4)
                        System.out.println("Error!\nYou inserted a undefined option, please choose from the ones above.");
                } catch (InputMismatchException e) {
                    System.out.println("Error!\nYou inserted a letter, please insert the number corresponding the option from above.");
                }
            } while (choice > 4);

            switch (choice) {
                case 1:
                    insertPlayer(playerList);
                    choice = 999;
                break;

                case 2:
                    showPlayers(playerList);
                    choice = 999;
                break;

                case 3:
                    if (playerList.size() == 0)
                        System.out.println("No player signed for the game!\nInsert new players in order to play.");
                    else
                        new Game().startGame(playerList);

                    choice = 999;
                break;

            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*       WELCOME TO THE GOOSE GAME           *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");

        readOption();

        System.out.println("\nGoodbye!");
    }
}
