import java.util.*;

public class mainClass {
    private static final String[] POSSIBLE_CHOICES = {"add", "show", "start", "exit"};

    private static void readOption() {
        boolean exit = false;
        List<Player> playerList = new ArrayList<>();

        do {
            String choice = "";

            System.out.println("\nChoose what to do: \n");

            System.out.println("- Add New Player");
            System.out.println("- Show Signed Players");
            System.out.println("- Start Game");
            System.out.println("- Exit\n");

            String[] valuesFromInput;

            do {
                Scanner in = new Scanner(System.in);

                valuesFromInput = in.nextLine().trim().split("\\s+");

                if (!Arrays.asList(POSSIBLE_CHOICES).contains(valuesFromInput[0].toLowerCase()))
                    System.out.println("Error!\nYou inserted a undefined option, please choose from the ones above.");
                else
                    choice = valuesFromInput[0].toLowerCase();

            } while (choice.isEmpty());

            switch (choice) {
                case "add":
                    String username = null;

                    if (valuesFromInput.length > 2)
                        username = valuesFromInput[valuesFromInput.length - 1];

                    new PlayerImpl(playerList).insertPlayer(username);
                break;

                case "show":
                    new PlayerImpl(playerList).showPlayers();
                break;

                case "start":
                    if (playerList.size() <= 1)
                        System.out.println("Not enough players signed for the game!\nIn order to play there must be at least two.");
                    else
                        new Game(playerList).startGame();
                break;

                case "exit":
                    exit = true;
                break;

            }
        } while (!exit);

        System.out.println("\nGoodbye!");
    }

    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*       WELCOME TO THE GOOSE GAME           *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");

        readOption();
    }
}
