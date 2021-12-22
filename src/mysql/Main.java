package mysql;

import mysql.controllers.ShopController;
import mysql.models.Shop;
import mysql.views.ShopView;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("Lindt");

        ShopView view = new ShopView();

        DatabaseConnection databaseConnection = new DatabaseConnection();

        ShopController controller = new ShopController(view, shop, databaseConnection);
    }
}
