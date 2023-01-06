/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fruit;

/**
 *
 * @author Naser
 */
public class DatabaseConnection {

    static Connection conn = null;
    static Statement stmt = null;
    private static final String USER = "root";
    private static final String PASSWORD = "Naser1987";

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruit?", USER, PASSWORD);
                stmt = conn.createStatement();

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("the connection has been closed");
            } catch (SQLException ex) {

            }
        }
    }

    public static int insertData(Fruit fruit) {
        int result = -1;

        try {
            if (stmt != null) {
                if (isExist(fruit) != -1) {
                    JOptionPane.showMessageDialog(null, "the fruit is already exists");
                } else {
                    result = stmt.executeUpdate(
                            "INSERT INTO fruitdetails(fruitName,gram,calories,"
                            + "caloriesfromFat,totalFat_g,sodium_mg,"
                            + "potassium_mg,totalCarb_g,dietaryFiber_g,sugars_g,protein_g,vitaminA_DV,vitaminC_DV,"
                            + "calcum_DV,iron_DV,image) VALUES ('"
                            + fruit.fruitName + "'," + fruit.gram + ","
                            + fruit.Calories + "," + fruit.CaloriesfromFat + ","
                            + fruit.TotalFat_g + "," + fruit.Sodium_mg + ","
                            + fruit.Potassium_mg + "," + fruit.TotalCarb_g + ","
                            + fruit.DietaryFiber_g + "," + fruit.Sugars_g + ","
                            + fruit.Protein_g + "," + fruit.VitaminA_DV + ","
                            + fruit.VitaminC_DV + "," + fruit.Calcum_DV + ","
                            + fruit.Iron_DV + ",'" + fruit.image + "')"
                    );
                }
            }
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }
        return result;
    }

    public static int isExist(Fruit fruit) {
        int id = -1;
        try {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM fruitdetails");

            while (resultSet.next()) {

                if (fruit.fruitName.equalsIgnoreCase(resultSet.getString(2))) {
                    id = resultSet.getInt("id");
                    break;
                }
            }
        } catch (SQLException ex) {

        }
        return id;
    }

    public static ArrayList<Fruit> getData() {
        ResultSet result = null;
        ArrayList<Fruit> fruits = new ArrayList<>();
        try {
            String sql = "SELECT * FROM fruitdetails";
            result = stmt.executeQuery(sql);
            while (result.next()) {
                Fruit f = new Fruit(result.getInt("id"), result.getInt("gram"), result.getString("fruitName"),
                        result.getString("image"), result.getFloat("Calories"),
                        result.getFloat("CaloriesfromFat"), result.getFloat("TotalFat_g"),
                        result.getFloat("Sodium_mg"), result.getFloat("Potassium_mg"),
                        result.getFloat("TotalCarb_g"), result.getFloat("DietaryFiber_g"),
                        result.getFloat("Sugars_g"), result.getFloat("Protein_g"),
                        result.getFloat("VitaminA_DV"), result.getFloat("VitaminC_DV"),
                        result.getFloat("Calcum_DV"), result.getFloat("Iron_DV"));
                fruits.add(f);
            }
        } catch (SQLException ex) {

        }
        return fruits;

    }

    public static Fruit getData(int id) {
        Fruit f = null;
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM fruitdetails";
            result = stmt.executeQuery(sql);
            while (result.next()) {
                if (result.getInt("id") == id) {
                    f = new Fruit(id, result.getInt("gram"),
                            result.getString("fruitName"), result.getString("image"),
                            result.getFloat("calories"), result.getFloat("caloriesfromFat"),
                            result.getFloat("totalFat_g"), result.getFloat("sodium_mg"),
                            result.getFloat("potassium_mg"), result.getFloat("totalCarb_g"),
                            result.getFloat("dietaryFiber_g"), result.getFloat("sugars_g"),
                            result.getFloat("protein_g"), result.getFloat("vitaminA_DV"),
                            result.getFloat("vitaminC_DV"), result.getFloat("calcum_DV"),
                            result.getFloat("iron_DV"));
                    break;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return f;
    }
}
