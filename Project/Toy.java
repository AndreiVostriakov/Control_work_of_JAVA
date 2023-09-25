package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Toy {
    private String id;
    private String name;
    private int frequency;
    
    public Toy(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        int[] weight = new int[3];
        String[] ids = new String[3];
        String[] names = new String[3];

        toys.add(new Toy("id1", "name1", 5));
        toys.add(new Toy("id2", "name2", 3));
        toys.add(new Toy("id3", "name3", 2));

        for (int i = 0; i < 3; i++) {
            Toy toy = toys.get(i);
            ids[i] = toy.getId();
            names[i] = toy.getName();
            weight[i] = toy.getFrequency();
        }

        Queue<Toy> queue = new PriorityQueue<>(3, Comparator.comparingInt(Toy::getFrequency));
        for (int i = 0; i < 3; i++) {
            queue.offer(toys.get(i));
        }

        try (PrintWriter writer = new PrintWriter(new File("output.txt"))) {
            for (int i = 0; i < 10; i++) {
                Toy toy = queue.poll();
                writer.println(toy.getId() + " " + toy.getName() + " " + toy.getFrequency());
                queue.offer(toy);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}