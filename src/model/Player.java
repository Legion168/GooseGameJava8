package model;

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
        this.pos = (int) (Math.random() * ((100-50)+1)+50);
        System.out.println(pos);
    }

    @Override
    public String toString() {
        return " - " + username.toUpperCase();
    }

    @Override
    public int compareTo(Player o) {
        return this.getPos().compareTo(o.getPos());
    }
}
