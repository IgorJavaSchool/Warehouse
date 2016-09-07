package yanevskyy;

import java.util.List;

/**
 * Uses as imitations the warehouse.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Warehouse extends Storage {

    /**
     * Default constructor
     *
     * @param foods
     */
    public Warehouse(List<Food> foods, boolean fullStorage) {
        super(foods, fullStorage);
    }

    @Override
    public boolean checkQuality(Food food) {
        if (food.percentExpiration() < 25 && !isFullStorage())
            return true;
        else return false;
    }
}
