package guild;

public class Player {
    //name: String
    // clazz: String
    // rank: String – &quot;Trial&quot; by default
    // description: String – &quot;n/a&quot; by default
    private String name;
    private String clazz;
    private  String rank;
    private  String description;

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return String.format("Player %s: %s%nRank: %s%nDescription: %s", this.getName()
        ,this.getClazz(), getRank(), getDescription());
    }
}
