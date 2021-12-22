package mvc.models;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private List<Candy> candies;

    public Shop(String name) {
        this.name = name;
        this.candies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", candies=" + candies +
                '}';
    }
}
