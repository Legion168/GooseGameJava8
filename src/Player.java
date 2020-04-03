public class Player implements Comparable<Player> {
    private String username;
    private Integer pos;

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Player(String username) {
        this.username = username;
        this.pos = 0;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public int compareTo(Player o) {
        return this.getPos().compareTo(o.getPos());
    }
}
