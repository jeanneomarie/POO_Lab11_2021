package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShopView extends JFrame{
    private JTextField nameField;
    private JTextField priceField;
    private JTextField totalField;

    private JButton createButton;
    private JButton showButton;
    private JButton computeTotalButton;

    private JTextArea candiesText;

    public ShopView() {
        this.setBounds(100, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Candy Shop");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        titleLabel.setBounds(251, 21, 118, 40);
        this.getContentPane().add(titleLabel);

        nameField = new JTextField();
        nameField.setBounds(72, 101, 118, 19);
        this.getContentPane().add(nameField);
        nameField.setColumns(10);

        createButton = new JButton("CREATE");
        createButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        createButton.setBounds(84, 187, 85, 21);
        this.getContentPane().add(createButton);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setBounds(24, 104, 45, 13);
        this.getContentPane().add(nameLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        priceLabel.setBounds(24, 139, 45, 13);
        this.getContentPane().add(priceLabel);

        priceField = new JTextField();
        priceField.setColumns(10);
        priceField.setBounds(72, 137, 118, 19);
        this.getContentPane().add(priceField);

        candiesText = new JTextArea();
        candiesText.setBounds(338, 121, 269, 155);
        candiesText.setLineWrap(true);
        this.getContentPane().add(candiesText);

        showButton = new JButton("SHOW");
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        showButton.setBounds(429, 80, 85, 21);
        this.getContentPane().add(showButton);

        totalField = new JTextField();
        totalField.setBounds(84, 294, 96, 19);
        this.getContentPane().add(totalField);
        totalField.setColumns(10);

        computeTotalButton = new JButton("Compute Total");
        computeTotalButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        computeTotalButton.setBounds(68, 263, 135, 21);
        this.getContentPane().add(computeTotalButton);

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        totalLabel.setBounds(24, 296, 45, 13);
        this.getContentPane().add(totalLabel);

        this.setVisible(true);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String nameField) {
        this.nameField.setText(nameField);
    }

    public double getPriceField() {
        return Double.parseDouble(priceField.getText());
    }

    public void setPriceField(double priceField) {
        this.priceField.setText(String.valueOf(priceField));
    }

    public double getTotalField() {
        return Double.parseDouble(totalField.getText());
    }

    public void setTotalField(double totalField) {
        this.totalField.setText(String.valueOf(totalField));
    }

    public String getCandiesText() {
        return candiesText.getText();
    }

    public void setCandiesText(String candiesText) {
        this.candiesText.setText(candiesText);
    }

    public void addCreateListener(ActionListener action) {
        createButton.addActionListener(action);
    }

    public void addShowListener(ActionListener action) {
        showButton.addActionListener(action);
    }

    public void addComputeTotalListener(ActionListener action) {
        computeTotalButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        refresh();
    }

    public void refresh() {
        nameField.setText(null);
        priceField.setText(null);
        totalField.setText(null);
        candiesText.setText(null);
    }
}
