package mvc;

import mvc.controllers.ShopController;
import mvc.models.Candy;
import mvc.models.Shop;
import mvc.views.ShopView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Candy> candies = new ArrayList<>();
        candies.add(new Candy("Twix", 12));
        candies.add(new Candy("Lion", 14));
        candies.add(new Candy("Bounty", 24));
        candies.add(new Candy("Mars", 8));
        candies.add(new Candy("Snickers", 23));

        Shop shop = new Shop("Lindt");
        shop.setCandies(candies);

        ShopView view = new ShopView();
        ShopController controller = new ShopController(view, shop);
    }
}
