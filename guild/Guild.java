package guild;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player p : roster
        ) {
            if (p.getName().equals(name)) {
                return roster.remove(p);
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player p : roster
        ) {
            if (p.getName().equals(name)) {
                p.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player p : roster
        ) {
            if (p.getName().equals(name)) {
                p.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kicked = new ArrayList<>();
        List<Player> left = new ArrayList<>();
        for (Player player : roster
        ) {
            if (player.getClazz().equals(clazz)) {
                kicked.add(player);
            } else {
                left.add(player);
            }
        }
        Player[] arr = new Player[kicked.size()];
        for(int i = 0; i< kicked.size(); i++){
            arr[i] = kicked.get(i);
        }
        roster = left;
        return arr;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Players in the guild: %s", this.name)).append(System.lineSeparator());
        for (Player pl : roster
        ) {
            sb.append(pl.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
