import java.util.IntSummaryStatistics;
import java.util.stream.*;
import java.util.*;

class Animal implements Comparable<Animal>{
    String name;
    String type;
    int population;
    Double avgDimention;

    public Animal(String name, String type, int population, Double avgDimention){
        this.name = name;
        this.type = type;
        this.population = population;
        this.avgDimention = avgDimention;
    }

    public int getPopulation(){
        return population;
    }

    public Double getAvgDimention(){
        return avgDimention;
    }

    @Override
    public String toString(){
        return "Animal name : " + name + " Type : " + type ;
    }

    @Override
    public int compareTo(Animal other){
        return name.compareTo(other.name);
    }
}

public class stream_summaries{
    public static void main(String[] args) {
        Animal cat = new Animal("Cat", "Mammel", 100, 20.0);
        Animal dog = new Animal("Dog", "Mammel", 100, 80.0);
        Animal falcon = new Animal("Falcon", "Bird", 50, 60.0);
        Animal lizard = new Animal("Lizard", "Reptile", 10, 8.0);

        System.out.println("\nSummary Stats of stream1 : ");
        Stream<Animal> stream1 = Stream.of(cat, dog, falcon, lizard);
        IntSummaryStatistics stats1 = stream1.collect(Collectors.summarizingInt(Animal::getPopulation));
        System.out.println("Count : " + stats1.getCount());
        System.out.println("Max : " + stats1.getMax());
        System.out.println("Min : " + stats1.getMin());
        System.out.println("Sum : " + stats1.getSum());
        System.out.println("Average : " + stats1.getAverage());

        System.out.println("\nSummary Stats of stream2 : ");
        Stream<Animal> stream2 = Stream.of(cat, dog, falcon, lizard);
        DoubleSummaryStatistics stats2 = stream2.collect(Collectors.summarizingDouble(Animal::getAvgDimention));
        System.out.println("Count : " + stats2.getCount());
        System.out.println("Max : " + stats2.getMax());
        System.out.println("Min : " + stats2.getMin());
        System.out.println("Sum : " + stats2.getSum());
        System.out.println("Average : " + stats2.getAverage());
    }
}