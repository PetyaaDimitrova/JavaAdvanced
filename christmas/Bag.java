package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
    public int count(){
        return data.size();
    }
    public void add(Present present){
        if(data.size() < capacity){
            data.add(present);
        }
    }
    public boolean remove(String name){
        Present present = data.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
        if(present == null){
            return false;
        }
        data.remove(present);
        return true;
    }
    public Present heaviestPresent(){
        double heaviest = 0;
        Present present = null;
        for (Present p: data
             ) {
            if(p.getWeight() > heaviest){
                present = p;
                heaviest = p.getWeight();
            }
        } 
        return present;
    }
    public Present getPresent(String name){
        return data.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:", color)).append(System.lineSeparator());
        for (Present p: data
             ) {
            sb.append(p.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
