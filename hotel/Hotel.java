package hotel;

import java.util.ArrayList;
import java.util.Collection;

public class Hotel {
    private String name;
    private int capacity;
    private Collection<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(roster.size() < capacity){
            roster.add(person);
        }
    }
    public boolean  remove(String name){
        Person person =  roster.stream().filter(r->r.getName().equals(name)).findFirst().orElse(null);

        return roster.remove(person);
    }
    public Person getPerson(String name, String hometown){
        return roster.stream().filter(r->r.getName().equals(name) && r.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount(){
        return roster.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:",name)).append(System.lineSeparator());
        for (Person person: roster
             ) {
            sb.append(person.toString());
        }
        return sb.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
