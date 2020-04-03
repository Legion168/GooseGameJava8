import java.util.*;

public class PlayerImpl implements PlayerInterface {
    private static final int[] GOOSE_CELL = {5, 9, 14, 18, 23, 27};
    private static final int BRIDGE_CELL = 6;

    private List<Player> playerList;

    @Override
    public void insertPlayer(String username) {
        boolean found;

        do {
            String finalUsername = username;

            if (playerList.stream().anyMatch(p -> p.getUsername().equalsIgnoreCase(finalUsername))) {
                System.out.println("Name already taken!\nPlease insert new one.");
                found = true;
            } else if (finalUsername.isEmpty()) {
                System.out.println("Name inserted is empty!\nPlease insert a valid name.");
                found = true;
            } else {
                found = false;
            }

            if (found) {
                Scanner scanner = new Scanner(System.in);

                username = scanner.nextLine().trim();
            }
        } while (found);

        System.out.println("\nPlayer " + username + " joined the game!");

        playerList.add(new Player(username));
    }

    @Override
    public void showPlayers() {
        System.out.println("       PLAYERS     ");
        System.out.println("---------------------");

        if (playerList.size() > 0)
            playerList.forEach(System.out::println);
        else
            System.out.println("No player joined yet!");
    }

    @Override
    public void quitPlayer(Player player) {
        System.out.println("\nThe player " + player.getUsername() + " decided to quit from the game...");
        playerList.remove(player);
    }

    @Override
    public void showBoard() {
        System.out.println("            BOARD           ");
        System.out.println("------------------------------");

        List<Player> tempList = new ArrayList<>(playerList);

        tempList.sort(Collections.reverseOrder());
        tempList.forEach(el -> System.out.println(el.getUsername() + " is on cell: " + el.getPos()));
    }

    @Override
    public int checkPlayerCell(Player player, int nextPos, int sum) {
        int checkValue = nextPos;

        if( Arrays.stream(GOOSE_CELL).anyMatch(i -> i == checkValue)) {
            System.out.println("Player " + player.getUsername() + " is on Goose Cell so it moves again!");
            nextPos = checkPlayerCell(player, nextPos + sum, sum);
        } else if (BRIDGE_CELL == nextPos) {
            System.out.println("Player " + player.getUsername() + " is on the Brige Cell so he jumps to 12!");
            nextPos = 12;
        } else {
            System.out.println("Player " + player.getUsername() + " moves from " + (player.getPos() == 0 ? "start" : player.getPos()) + " to " + (nextPos > 63 ? "63" : nextPos));
        }

        return nextPos;
    }

    public PlayerImpl(List<Player> playerList) {
        this.playerList = playerList;
    }
}
