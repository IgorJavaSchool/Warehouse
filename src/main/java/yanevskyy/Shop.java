package yanevskyy;

/**
 * Uses as imitations the shop.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Shop extends Storage {

    @Override
    public boolean checkQuality(Food food) {
        if (food.percentExpiration() > 25 && food.percentExpiration() < 75) {
            return true;
        }  else if (food.percentExpiration() > 75 && food.percentExpiration() < 100) {
            food.setDiscount(50);
            return true;
        }  else return false;
    }
}
