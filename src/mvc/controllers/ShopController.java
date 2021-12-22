package mvc.controllers;

import mvc.models.Candy;
import mvc.models.Shop;
import mvc.views.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopController {
    private ShopView view;
    private Shop shop;

    public ShopController(ShopView view, Shop shop) {
        this.view = view;
        this.shop = shop;

        this.view.addCreateListener(new CreateListener());
        this.view.addShowListener(new ShowListener());

        // expresie lambda
        // https://www.w3schools.com/java/java_lambda.asp
        this.view.addComputeTotalListener((e) -> {
            double totalSum = 0;
            for (Candy candy : shop.getCandies()) {
                totalSum += candy.getPrice();
            }
            view.setTotalField(totalSum);
        });
    }

    class CreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // ne luam datele de pe view
                String name = view.getNameField();
                double price = view.getPriceField();

                // facem un obiect de tip Candy
                Candy candy = new Candy(name, price);

                // adaugam obiectul in lista de candies a shop-ului
                shop.getCandies().add(candy);

                System.out.println(shop.getCandies());
            } catch (Exception exception) {
                view.showMessage("Bad Input :(");
            }
        }
    }

    class ShowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setCandiesText(shop.getCandies().toString());
            System.out.println(shop.getCandies());
        }
    }
}
