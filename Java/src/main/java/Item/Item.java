package Item;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        sellIn--;
        quality--;

        if(sellIn<0)
            quality--;
    }

    public void checkConstraints(){
        quality = Math.max(quality, 0);
        quality = Math.min(quality, 50);
    }


}
