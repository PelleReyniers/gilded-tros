package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void defaultItemQDecreaseTest() {
        Item[] items = new Item[] { new Item("Ring of Cleansening Code", 10, 20) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void defaultItemQDecreaseSubZeroTest() {
        int startQ = 10;
        Item[] items = new Item[] { new Item("foo", 0, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(startQ-2, app.items[0].quality);
    }

    @Test
    void legendaryItemQTest(){
        Item[] items = new Item[] { new Item("B-DAWG Keychain", 0, 80) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertAll(() -> assertEquals(80, app.items[0].quality),
                () -> assertEquals(0, app.items[0].sellIn));

    }

    @Test
    void legendaryItemQSubZeroTest(){
        Item[] items = new Item[] { new Item("B-DAWG Keychain", -1, 80) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertAll(() -> assertEquals(80, app.items[0].quality),
                () -> assertEquals(-1, app.items[0].sellIn));

    }
    @Test
    void goodWineItemQTest(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Good Wine", 10, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(startQ+1, app.items[0].quality);
    }
    @Test
    void goodWineItemQSubZeroTest(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Good Wine", 0, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(startQ+2, app.items[0].quality);
    }
    @Test
    void backStageItemQTest(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 15, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(startQ+1, app.items[0].quality);
    }

    @Test
    void backStageItemQSub10Test(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 10, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(startQ+2, app.items[0].quality);
    }

    @Test
    void backStageItemQSub5Test(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 5, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(startQ+3, app.items[0].quality);
    }

    @Test
    void backStageItemQSub0Test(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 0, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void smellyItemQTest(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Duplicate Code", 10, startQ),
                new Item("Long Methods", 10, startQ),
                new Item("Ugly Variable Names", 10, startQ) };

        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertAll(() -> assertEquals(startQ-2, app.items[0].quality),
                () -> assertEquals(startQ-2, app.items[1].quality),
                () -> assertEquals(startQ-2, app.items[2].quality));
    }

    @Test
    void smellyItemQSubZeroTest(){
        int startQ = 10;
        Item[] items = new Item[] { new Item("Duplicate Code", 0, startQ),
                new Item("Long Methods", 0, startQ),
                new Item("Ugly Variable Names", 0, startQ) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertAll(() -> assertEquals(startQ-4, app.items[0].quality),
                () -> assertEquals(startQ-4, app.items[1].quality),
                () -> assertEquals(startQ-4, app.items[2].quality));
    }

    @Test
    void qualitySubZeroTest(){
        Item[] items = new Item[] { new Item("Duplicate Code", 0, 2) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityOver50Test(){
        Item[] items = new Item[] { new Item("Good Wine", 0, 50) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void oldNewCompare(){

        GildedTros appOld = new GildedTros(generatePartialDataSet());
        GildedTros appNew = new GildedTros(generatePartialDataSet());
        StringBuilder strOld = new StringBuilder();
        StringBuilder strNew = new StringBuilder();
        int days = 100;

        for (int i = 0; i < days; i++) {
            for (Item item : appOld.items) {
                strOld.append(item.toString());
            }
            for (Item item : appNew.items) {
                strNew.append(item.toString());
            }
            appOld.updateQualityDeprecated();
            appNew.updateQuality();
        }

        assertEquals(strOld.toString(),strNew.toString());
    }

    private Item[] generatePartialDataSet(){
        return new Item[] {
                new Item("Ring of Cleansening Code", 10, 20),
                new Item("Good Wine", 2, 0),
                new Item("Elixir of the SOLID", 5, 7),
                new Item("B-DAWG Keychain", 0, 80),
                new Item("B-DAWG Keychain", -1, 80),
                new Item("Backstage passes for Re:Factor", 15, 20),
                new Item("Backstage passes for Re:Factor", 10, 49),
                new Item("Backstage passes for HAXX", 5, 49)};
    }

}
