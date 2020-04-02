import model.Player;

import java.util.*;

public class Game {
    private void lazyMode(List<Player> playerList, int index) {

    }

    private void activeMode(List<Player> playerList, int index) {

    }

    private void quitPlayer(List<Player> playerList, int index) {
        System.out.println("\nThe player " + playerList.get(index).getUsername() + " decided to quit from the game...");
        playerList.remove(index);
    }

    private void showBoard(List<Player> playerList) {
        System.out.println("            BOARD           ");
        System.out.println("----------------------------");

        List<Player> tempList = new ArrayList<>(playerList);

        tempList.sort(Collections.reverseOrder());
        tempList.forEach(el -> System.out.println(el.getUsername() + " is on cell: " + el.getPos()));
    }

    public void startGame(List<Player> playerList) {
            int choice = 999, index = 0;
            String winner = "";

            System.out.println("Order List: \n");
            playerList.forEach(System.out::println);

            do {
                boolean moveOn = false;

                do {
                    int cell = playerList.get(index).getPos();

                    System.out.println("\n" + playerList.get(index).getUsername() + " it's your turn, you are on cell: "
                            + cell + ", choose what to do: \n");

                    System.out.println("1) Play Lazy Mode");
                    System.out.println("2) Play Active Mode");
                    System.out.println("3) Look on Board");
                    System.out.println("4) Quit\n");

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
                            lazyMode(playerList, index);
                            choice = 999;
                            moveOn = true;
                        break;

                        case 2:
                            activeMode(playerList, index);
                            choice = 999;
                            moveOn = true;
                        break;

                        case 3:
                            showBoard(playerList);
                            choice = 999;
                        break;

                        case 4:
                            quitPlayer(playerList, index);
                            choice = 999;
                            moveOn = true;
                            index--;
                        break;
                    }

                } while (!moveOn);

                index++;

                if (index >= playerList.size())
                    index = 0;

            } while (playerList.size() > 0);

        System.out.println("\nEnd of game!");

        if (!winner.isEmpty())
            System.out.println("The winner is: " + winner);
        else
            System.out.println("No one won becouse everyone quit the game before finish!!");
    }
}
