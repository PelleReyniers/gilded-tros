package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQualityDeprecated() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Good Wine")
                    && !items[i].name.equals("Backstage passes for Re:Factor")
                    && !items[i].name.equals("Backstage passes for HAXX"))
            {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("B-DAWG Keychain")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes for Re:Factor") || items[i].name.equals("Backstage passes for HAXX") ) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("B-DAWG Keychain")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Good Wine")) {
                    if (!items[i].name.equals("Backstage passes for Re:Factor") && !items[i].name.equals("Backstage passes for HAXX")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("B-DAWG Keychain")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    public void updateQuality(){
        for(Item item : items){
            if(!item.name.equals("B-DAWG Keychain")){
                updateSingleItem(item);
                checkConstraints(item);
            }
        }
    }

    private void updateSingleItem(Item item) {
        item.sellIn--;
        int qualityIncrease = item.sellIn<0 ? -2: -1;

        if(item.name.equals("Good Wine")){
            qualityIncrease *= (-1);
        }else if(item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")){
            if(item.sellIn>=0){
                qualityIncrease *= (-1);
                if (item.sellIn<10)
                    qualityIncrease++;
                if (item.sellIn<5)
                    qualityIncrease++;
            } else {
                qualityIncrease = item.quality * (-1);
            }
        }else if(item.name.equals("Duplicate Code") || item.name.equals("Long Methods")|| item.name.equals("Ugly Variable Names")){
            qualityIncrease*=2;
        }

        item.quality+=  qualityIncrease;
    }

    private void checkConstraints(Item item){
        item.quality = Math.max(item.quality, 0);
        item.quality = Math.min(item.quality, 50);
    }


}