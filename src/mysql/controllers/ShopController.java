package mysql.controllers;

import mysql.DatabaseConnection;
import mysql.models.Candy;
import mysql.models.Shop;
import mysql.views.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShopController {
    private ShopView view;
    private Shop shop;

    private DatabaseConnection databaseConnection;

    public ShopController(ShopView view, Shop shop, DatabaseConnection databaseConnection) {
        this.view = view;
        this.shop = shop;
        this.databaseConnection = databaseConnection;

        this.view.addInsertListener(new InsertListener());
        this.view.addSelectListener(new SelectListener());
        this.view.addComputeTotalListener(e -> {
            double totalSum = 0;
            for (Candy candy : shop.getCandies()) {
                totalSum += candy.getPrice();
            }
            view.setTotalField(totalSum);
        });
    }

    class InsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // facem o conexiune spre baza noastra de date
                Connection connection = databaseConnection.getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement("insert into candies (name, price)" + "values (?, ?)");

                preparedStatement.setString(1, view.getNameField());
                preparedStatement.setDouble(2, view.getPriceField());

                preparedStatement.executeUpdate();

                connection.close();

                view.showMessage("Candy successfully added!");
            } catch (Exception ex) {
                view.showMessage("Bad input!");
            }
        }
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM candies";

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    int id = result.getInt(1);
                    String name = result.getString(2);
                    double price = result.getDouble(3);
                    shop.getCandies().add(new Candy(id, name, price));
                }

                view.setCandiesText(shop.getCandies().toString());

                connection.close();
            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
                ex.printStackTrace();
            }
        }
    }
}
