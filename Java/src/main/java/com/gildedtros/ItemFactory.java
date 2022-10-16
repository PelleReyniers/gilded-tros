package com.gildedtros;

import Item.Item;
import Item.GoodWineItem;
import Item.LegendaryItem;
import Item.BackstageItem;
import Item.SmellyItem;

public class ItemFactory {

    public static Item createItem(String name, int sellIn, int quality){
        if(name.equals("Good Wine"))
            return new GoodWineItem(name, sellIn, quality);
        if(name.equals("B-DAWG Keychain"))
            return new LegendaryItem(name,sellIn,quality);
        if (name.equals("Backstage passes for Re:Factor")||name.equals("Backstage passes for HAXX"))
            return new BackstageItem(name, sellIn, quality);
        if (name.equals("Duplicate Code")||name.equals("Long Methods")||name.equals("Ugly Variable Names"))
            new SmellyItem(name, sellIn, quality);
        return new Item(name, sellIn, quality);
    }
}
