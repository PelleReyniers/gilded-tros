package Item;

public class BackstageItem extends Item {
    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        sellIn--;
        if(sellIn>=0){
            quality++;
            if(sellIn<10)
                quality++;
            if(sellIn<5)
                quality++;
        }else{
            quality = 0;
        }
    }
}
