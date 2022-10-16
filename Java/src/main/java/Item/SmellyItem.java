package Item;

public class SmellyItem extends Item {

    public SmellyItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        sellIn--;
        if(sellIn<0)
            quality-=4;
        else
            quality-=2;
    }
}
