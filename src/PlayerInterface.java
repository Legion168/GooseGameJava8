import java.util.List;

public interface PlayerInterface {
    void insertPlayer(String name);

    void showPlayers();

    void quitPlayer(Player player);

    void showBoard();

    int checkPlayerCell(Player player, int nextPos, int sum);
}
