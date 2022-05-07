package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet pet = data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (pet == null) {
            return false;
        }
        data.remove(pet);
        return true;
    }

    public Pet getPet(String name, String owner) {
        return data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for(int i =0; i<data.size();i++){
           sb.append(String.format("%s %s", data.get(i).getName(), data.get(i).getOwner())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
