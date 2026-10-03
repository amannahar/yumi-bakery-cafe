package com.yumi.cafe;

import com.yumi.cafe.model.MenuItem;
import com.yumi.cafe.repository.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class YumiApplication {
  public static void main(String[] args) { SpringApplication.run(YumiApplication.class, args); }

  @Bean CommandLineRunner seed(MenuItemRepository repo) {
    return args -> {
      if (repo.count() > 0) return;
      record Seed(String category,String name,int price,Integer medium){ }
      var s = List.of(
        new Seed("Pizza","Margherita Pizza",89,129),new Seed("Pizza","Veggie Pizza",109,149),new Seed("Pizza","Cheese Corn Pizza",119,159),new Seed("Pizza","Paneer Pizza",129,169),new Seed("Pizza","Tandoori Paneer Pizza",149,189),new Seed("Pizza","Cheese Paneer Pizza",159,199),new Seed("Pizza","YUMI Special Pizza",179,229),
        new Seed("Sandwich","Veg Sandwich",49,null),new Seed("Sandwich","Veg Grilled Sandwich",59,null),new Seed("Sandwich","Cheese Sandwich",69,null),new Seed("Sandwich","Cheese Corn Sandwich",79,null),new Seed("Sandwich","Paneer Sandwich",79,null),new Seed("Sandwich","Tandoori Paneer Sandwich",89,null),new Seed("Sandwich","YUMI Special Sandwich",99,null),
        new Seed("Burger","Veg Burger",49,null),new Seed("Burger","Cheese Burger",69,null),new Seed("Burger","Paneer Burger",79,null),new Seed("Burger","Cheese Paneer Burger",89,null),new Seed("Burger","Tandoori Paneer Burger",89,null),new Seed("Burger","YUMI Special Burger",99,null),
        new Seed("Wraps","Veg Wrap",49,null),new Seed("Wraps","Cheese Veg Wrap",59,null),new Seed("Wraps","Paneer Wrap",59,null),new Seed("Wraps","Tandoori Paneer Wrap",79,null),new Seed("Wraps","Cheese Paneer Wrap",89,null),new Seed("Wraps","YUMI Special Wrap",99,null),
        new Seed("Momos","Veg Steamed Momos",59,null),new Seed("Momos","Veg Fried Momos",69,null),new Seed("Momos","Paneer Momos",79,null),new Seed("Momos","Cheese Momos",89,null),new Seed("Momos","Kurkure Momos",99,null),new Seed("Momos","YUMI Special Momos",109,null),
        new Seed("Chowmein","Veg Chowmein",59,null),new Seed("Chowmein","Paneer Chowmein",79,null),new Seed("Chowmein","Cheese Chowmein",89,null),new Seed("Chowmein","YUMI Special Chowmein",99,null),
        new Seed("Manchurian","Veg Manchurian Dry",89,null),new Seed("Manchurian","Veg Manchurian Gravy",89,null),new Seed("Manchurian","Paneer Manchurian",119,null),new Seed("Manchurian","Cheese Manchurian",119,null),new Seed("Manchurian","Paneer Manchurian Gravy",119,null),new Seed("Manchurian","YUMI Special Manchurian",139,null),
        new Seed("Chilli Specials","Chilli Potato",79,null),new Seed("Chilli Specials","Honey Chilli Potato",89,null),new Seed("Chilli Specials","Chilli Paneer Dry",119,null),new Seed("Chilli Specials","Chilli Paneer Gravy",129,null),new Seed("Chilli Specials","YUMI Special Chilli Paneer",149,null),
        new Seed("Fries","French Fries",79,null),new Seed("Fries","YUMI Special Long Fries",99,null),
        new Seed("Maggi","Masala Maggi",59,null),new Seed("Maggi","Veg Maggi",59,null),new Seed("Maggi","Cheese Maggi",79,null),new Seed("Maggi","Paneer Maggi",79,null),new Seed("Maggi","YUMI Special Maggi",99,null),
        new Seed("Pav Bhaji","Classic Pav Bhaji",79,null),new Seed("Pav Bhaji","Cheese Pav Bhaji",99,null),new Seed("Pav Bhaji","YUMI Special Pav Bhaji",119,null),
        new Seed("Garlic Bread","Garlic Bread",79,null),new Seed("Garlic Bread","Cheese Garlic Bread",99,null),new Seed("Garlic Bread","YUMI Special Garlic Bread",119,null),
        new Seed("Pasta","Red Sauce Pasta",99,null),new Seed("Pasta","White Sauce Pasta",109,null),new Seed("Pasta","Pink Sauce Pasta",119,null),
        new Seed("Patties","Veg Patties",25,null),new Seed("Patties","Masala Patties",30,null),new Seed("Patties","Paneer Patties",35,null),new Seed("Patties","Tandoori Paneer Patties",40,null),new Seed("Patties","Cheese Patties",40,null),new Seed("Patties","Cheese Corn Patties",40,null),new Seed("Patties","YUMI Special Patties",45,null),
        new Seed("Mocktails","Lemon Mint",49,null),new Seed("Mocktails","Virgin Mojito",59,null),new Seed("Mocktails","Blue Lagoon",59,null),new Seed("Mocktails","Green Apple Mojito",59,null),new Seed("Mocktails","Watermelon Mojito",59,null),new Seed("Mocktails","Strawberry Mojito",69,null),new Seed("Mocktails","Lemon Soda",39,null),new Seed("Mocktails","YUMI Special Mocktail",79,null),
        new Seed("Shakes","Vanilla Shake",59,null),new Seed("Shakes","Chocolate Shake",69,null),new Seed("Shakes","Strawberry Shake",69,null),new Seed("Shakes","Banana Shake",59,null),new Seed("Shakes","Oreo Shake",79,null),new Seed("Shakes","KitKat Shake",89,null),new Seed("Shakes","Cold Coffee",69,null),new Seed("Shakes","Chocolate Cold Coffee",79,null),new Seed("Shakes","YUMI Special Shake",99,null),
        new Seed("Tea","Regular Tea",15,null),new Seed("Tea","Masala Tea",20,null),new Seed("Tea","Ginger Tea",20,null),new Seed("Tea","Lemon Tea",20,null),
        new Seed("Hot Coffee","Regular Coffee",20,null),new Seed("Hot Coffee","Espresso",40,null),new Seed("Hot Coffee","Americano",50,null),new Seed("Hot Coffee","Cappuccino",60,null),new Seed("Hot Coffee","Cafe Latte",70,null),
        new Seed("Cold Coffee","Cold Coffee",69,null),new Seed("Cold Coffee","Chocolate Cold Coffee",79,null),
        new Seed("Pastries","Fresh Cream Pastry",20,null),new Seed("Pastries","Vanilla Pastry",25,null),new Seed("Pastries","Pineapple Pastry",25,null),new Seed("Pastries","Chocolate Pastry",25,null),new Seed("Pastries","Black Forest Pastry",35,null),new Seed("Pastries","Red Velvet Pastry",40,null),
        new Seed("Cupcakes","Vanilla Cupcake",25,null),new Seed("Cupcakes","Chocolate Cupcake",30,null),new Seed("Cupcakes","Red Velvet Cupcake",40,null)
      );
      repo.saveAll(s.stream().map(x->new MenuItem(x.category(),x.name(),BigDecimal.valueOf(x.price()),x.medium()==null?null:BigDecimal.valueOf(x.medium()),true)).toList());
    };
  }
}
