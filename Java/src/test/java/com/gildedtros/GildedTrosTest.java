package com.gildedtros;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
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



}
