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
    public Warehouse(List<Food> foods) {
        super(foods);
    }

    @Override
    public boolean checkQuality(Food food) {
        if (food.percentExpiration() < 25)
            return true;
        else return false;
    }
}
