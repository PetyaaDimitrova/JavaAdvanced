package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (data.size()< capacity) {
            data.add(rabbit);
            rabbit.setAvailable(true);
        }
    }

    public boolean removeRabbit(String name) {
        Rabbit rabbit = data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        if (rabbit == null) {
            return false;
        }
        return data.remove(rabbit);
    }

    public void removeSpecies(String species) {
        data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = data.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
        if (rabbit != null) {
            rabbit.setAvailable(false);
        }
        return rabbit;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit r:data
             ) {
            if(r.getSpecies().equals(species)){
                rabbits.add(r);
                r.setAvailable(false);
            }
        }
        return rabbits;
    }
    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:", name)).append(System.lineSeparator());
        data = data.stream().filter(Rabbit::isAvailable).collect(Collectors.toList());
        for (Rabbit r:data
             ) {
            sb.append(r.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
