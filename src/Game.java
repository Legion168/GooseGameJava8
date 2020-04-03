import java.util.*;

public class Game {
    private static final String[] POSSIBLE_CHOICES = {"play", "active", "lazy", "look", "quit"};

    private List<Player> playerList;

    private boolean endGame = false;

    private void printMovement(Player player, String type) {
        String playerName =  player.getUsername();

        int sum, roll1, roll2;

        if ("A".equalsIgnoreCase(type)) {
            boolean correct = false;

            System.out.println("\nWrite how much " + playerName + " is going to move: ");

            do {
                Scanner in = new Scanner(System.in);

                String val = in.nextLine().replaceAll("[^0-9]+", " ").trim();

                String[] values = val.split(" ");

                roll1 = Integer.parseInt(values[0]);
                roll2 = Integer.parseInt(values[1]);

                if (roll1 > 6 || roll2 > 6)
                    System.out.println("Error!\nThe dice have only 6 faces, please write at max 6 for each dice!");
                else
                    correct = true;
            } while (!correct);
        } else {
            roll1 = (int) (Math.random() * ((6-1)+1)+1);
            roll2 = (int) (Math.random() * ((6-1)+1)+1);
        }

        sum = roll1 + roll2;

        System.out.println("Player " + playerName + " rolls " + roll1 + ", " + roll2 + ".");

        sum = new PlayerImpl(playerList).checkPlayerCell(player, player.getPos() + sum, sum);

        final int nextPos = sum;

        playerList.stream().filter(el -> el.getPos() == nextPos).findFirst().ifPresent(value -> {
            System.out.println("On " + nextPos + " there is the player " + value.getUsername() + "! Which now goes back to " + player.getPos() + ".");
            value.setPos(player.getPos());
        });

        if (sum > 63) {
            sum = 63 - (sum - 63);
            System.out.println("Player " + playerName + " bounces! " + playerName + " returns to " + sum + "!");
        } else if (sum == 63) {
            endGame = true;
        }

        player.setPos(sum);
    }

    public void startGame() {
        int index = 0;

        String winner = "";

        System.out.println("        ORDER LIST      ");
        System.out.println("--------------------------");
        playerList.forEach(System.out::println);

        do {
            boolean moveOn = false;

            do {
                String choice = "";
                int cell = playerList.get(index).getPos();

                System.out.println("\n" + playerList.get(index).getUsername() + " it's your turn, you are on cell: " + cell + ", choose what to do: \n");

                System.out.println("- Play Lazy Mode (The PC move the player)");
                System.out.println("- Play Active Mode (You move the player)");
                System.out.println("- Look on Board");
                System.out.println("- Quit\n");

                String[] valuesFromInput;

                do {
                    Scanner in = new Scanner(System.in);

                    valuesFromInput = in.nextLine().trim().split("\\s+");

                    String valToPass = valuesFromInput[0].toLowerCase();

                    if (!Arrays.asList(POSSIBLE_CHOICES).contains(valToPass))
                        System.out.println("Error!\nYou inserted a undefined option, please choose from the ones above.");
                    else if ("play".equalsIgnoreCase(valToPass) && valuesFromInput.length == 1)
                        System.out.println("Error!\nYou inserted a play option but not specify which one!");
                    else if ("play".equalsIgnoreCase(valToPass))
                        choice = valuesFromInput[1].toLowerCase();
                    else
                        choice = valuesFromInput[0].toLowerCase();

                } while (choice.isEmpty());

                switch (choice) {
                    case "lazy":
                        printMovement(playerList.get(index), "L");
                        moveOn = true;
                    break;

                    case "active":
                        printMovement(playerList.get(index), "A");
                        moveOn = true;
                    break;

                    case "look":
                        new PlayerImpl(playerList).showBoard();
                    break;

                    case "quit":
                        new PlayerImpl(playerList).quitPlayer(playerList.get(index));

                        if (playerList.size() == 1)
                            endGame = true;
                        else
                            index--;

                        moveOn = true;
                    break;
                }

            } while (!moveOn);

            if (!endGame)
                index++;

            if (index >= playerList.size())
                index = 0;

            winner = playerList.get(index).getUsername();
        } while (!endGame);

        System.out.println("\nEnd of game!");
        System.out.println("The winner is: " + winner);
    }

    public Game(List<Player> playerList) {
        this.playerList = playerList;
    }
}
