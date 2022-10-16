package Item;

public class GoodWineItem extends Item {
    public GoodWineItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        sellIn--;
        quality++;
        if(sellIn<0)
            quality++;
    }
}
