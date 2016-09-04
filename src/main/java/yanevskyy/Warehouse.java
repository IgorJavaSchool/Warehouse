package yanevskyy;

/**
 * Uses as imitations the warehouse.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Warehouse extends Storage {

    @Override
    public boolean checkQuality(Food food) {
        if (food.percentExpiration() < 25)
            return true;
        else return false;
    }
}
