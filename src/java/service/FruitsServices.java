/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Fruit;

/**
 *
 * @author Naser
 */
public class FruitsServices {

    static ArrayList<Fruit> fruits = new ArrayList<>();

    public static ArrayList<Fruit> getFruits() {
        File file = new File(controller.Control.path,"WEB-INF/Data/fruit.txt");
      // File file = new File("C:\\Users\\Naser\\Documents\\NetBeansProjects\\DailyCalorieIntake\\web\\WEB-INF\\Data\\fruit.txt");
        try {
           
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                Fruit f = new Fruit(line);
                fruits.add(f);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(FruitServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(FruitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruits;
    }

    public static Fruit getOneFruit(int id) {
        
        if(fruits.isEmpty()){
            getFruits();
        }
        Fruit fruit = fruits.get(id-1);
        return fruit;
    }
    public static void main(String[] args) {
        System.out.println(getOneFruit(1));  
    }
//    public static void insert() {
//        DatabaseUtilities.openConnection();
//        for (Fruit fruit : fruits) {
//             DatabaseUtilities.insertData(fruit);
//        }
//        DatabaseUtilities.closeConnection();
//    }
}
