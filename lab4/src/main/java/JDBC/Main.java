package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        final String URL = "jdbc:mysql://localhost:3306/production?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        final String userName = "root";
        final String password = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, userName, password);

        Scanner input = new Scanner(System.in);
        System.out.print("Введите колличество товара: ");
        final int numberProduct = input.nextInt();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product (prodid, title, cost) VALUE (?, ?, ?)");
        for (int i = 0; i < numberProduct; i++) {
            preparedStatement.setInt(1, i + 1);
            preparedStatement.setString(2, "product" + (i + 1));
            preparedStatement.setInt(3, new Random().nextInt(10000));
            preparedStatement.executeUpdate();
        }

        Command command = new Command(connection, numberProduct);

        System.out.print("Выбирите команду(Ввод-Y/Выйти-exit): ");
        String comm = input.next();
        while (comm != "exit") {
            System.out.print("Выбирите команду(1-add, 2-delete, 3-price, 4-filter_by_price, 5-show_price, 6-change_price): ");
            int numbers = input.nextInt();

            switch (numbers) {
                case 1 :
                    Command.addProduct();
                    break;

                case 2 :
                    Command.deleteProduct();
                    break;

                case 3 :
                    Command.priceProduct();
                    break;

                case 4 :
                    Command.filter_bi_priceProduct();
                    break;

                case 5 :
                    Command.show_allProduct();
                    break;

                case 6 :
                    Command.change_priceProduct();
                    break;

                default :
                    System.out.println("Нет такой команды!!!");
            }

            System.out.print("Выбирите команду(Ввод-Y/Выйти-exit): ");
            comm = input.next();
        }
    }
}
