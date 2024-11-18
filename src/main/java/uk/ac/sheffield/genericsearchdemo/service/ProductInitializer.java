package uk.ac.sheffield.genericsearchdemo.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import uk.ac.sheffield.genericsearchdemo.model.Product;
import uk.ac.sheffield.genericsearchdemo.repository.ProductRepository;

import java.util.Arrays;

@Service
public class ProductInitializer implements CommandLineRunner {
    private final ProductRepository productRepository;

    public ProductInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        initializeDefaultProducts();
    }

    private void initializeDefaultProducts() {
        Product[] products = {
                new Product("One Ring", 1000.0),
                new Product("Potatoes", 4.0),
                new Product("Orc", 50.50),
                new Product("Hobbit", 100.75),
                new Product("Sword", 150.0),
                new Product("Shield", 80.5),
                new Product("Elven Bow", 250.0),
                new Product("Potion", 15.0),
                new Product("Gondor Sword", 200.0),
                new Product("Dwarven Hammer", 300.0),
                new Product("Magic Stone", 120.0),
                new Product("Map", 30.0),
                new Product("Robe", 75.5),
                new Product("Staff", 200.0),
                new Product("Gondorian Helm", 90.0),
                new Product("Ring of Power", 999.99),
                new Product("Elven Boots", 110.0),
                new Product("Mithril Armor", 1200.0),
                new Product("Rohan Horse", 600.0),
                new Product("Gondorian Shield", 150.0),
                new Product("Wizard's Hat", 50.0),
                new Product("Fireball Spell", 80.0),
                new Product("Healing Potion", 25.0),
                new Product("Silver Necklace", 200.0),
                new Product("Emerald Ring", 180.0),
                new Product("Dragon Scale Armor", 950.0),
                new Product("Dragon Egg", 1000.0),
                new Product("Elven Cloak", 70.0),
                new Product("Iron Sword", 180.0),
                new Product("Steel Axe", 210.0),
                new Product("Goblin Skull", 15.0),
                new Product("Wizard's Staff", 150.0),
                new Product("Potion of Wisdom", 60.0),
                new Product("Fireball", 90.0),
                new Product("Wind Spirit", 55.0),
                new Product("Elf Bow", 220.0),
                new Product("Orc Helmet", 85.0),
                new Product("Gondolian Blade", 350.0),
                new Product("Elven Dagger", 110.0),
                new Product("Rohan Spear", 130.0),
                new Product("Gold Coins", 50.0),
                new Product("Ranger Cloak", 125.0),
                new Product("Gondor Flag", 70.0),
                new Product("Dragon Fang", 300.0),
                new Product("Ring of Stealth", 500.0),
                new Product("Elven Dagger", 90.0),
                new Product("Balin's Axe", 180.0),
                new Product("Gimli's Hammer", 210.0),
                new Product("Ring of Strength", 450.0),
                new Product("Elven Arrows", 15.0),
                new Product("Gondor Flag", 60.0),
                new Product("Dark Stone", 250.0),
                new Product("Silver Cup", 55.0),
                new Product("Elven Plate Armor", 700.0),
                new Product("Iron Boots", 80.0),
                new Product("Emerald Pendant", 95.0),
                new Product("Elven Shield", 150.0),
                new Product("Troll Club", 50.0),
                new Product("Gondor Warhammer", 270.0),
                new Product("Gimli's Shield", 160.0),
                new Product("Map of Mordor", 120.0),
                new Product("Ring of Fire", 500.0),
                new Product("Elven Longbow", 250.0),
                new Product("Elven Ring", 999.99),
                new Product("Sting", 300.0),
                new Product("Eowyn's Sword", 180.0),
                new Product("Troll Shield", 60.0),
                new Product("Dwarven Shield", 150.0),
                new Product("Gondorian Spear", 220.0),
                new Product("Gimli's Axe", 250.0),
                new Product("Silver Shield", 180.0),
                new Product("Elven Gloves", 75.0),
                new Product("Mithril Dagger", 210.0),
                new Product("Potion of Invisibility", 85.0),
                new Product("Gold Ring", 550.0),
                new Product("Mithril Sword", 800.0),
                new Product("Battleaxe", 400.0),
                new Product("Mithril Chainmail", 1300.0),
                new Product("Dark Elf Cloak", 120.0),
                new Product("Dragon's Claw", 220.0),
                new Product("Ancient Tome", 300.0),
                new Product("Troll Hammer", 250.0),
                new Product("Wizards Potion", 65.0),
                new Product("Orc Staff", 90.0),
                new Product("Black Cloak", 50.0),
                new Product("Sword of Rohan", 350.0),
                new Product("Gondor Boots", 120.0),
                new Product("Gimli's Belt", 45.0),
                new Product("Elven Crown", 200.0),
                new Product("Witch King's Sword", 500.0),
                new Product("Gondorian Armor", 1000.0),
                new Product("Ring of Wisdom", 400.0),
                new Product("Elven Spear", 220.0),
                new Product("Balin's Shield", 170.0),
                new Product("Warrior's Belt", 60.0),
                new Product("Iron Shield", 100.0),
                new Product("Rohan Helmet", 85.0),
                new Product("Elven Light", 90.0),
                new Product("Potion of Healing", 25.0),
                new Product("Dwarven Hammer", 300.0)
        };

        productRepository.saveAll(Arrays.asList(products));
    }

}
