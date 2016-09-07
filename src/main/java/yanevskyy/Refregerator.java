package yanevskyy;

import java.util.List;

/**
 * Keeps the foods recyclability.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Refregerator extends Storage {
    /**
     * Default constructor
     *
     * @param foods
     * @param fullStorage
     */
    public Refregerator(List<Food> foods, boolean fullStorage) {
        super(foods, fullStorage);
    }

    @Override
    public boolean checkQuality(Food food) {
        Recycling recycling;
        if (food.percentExpiration() >= 100 && food.isCanReproduct()) {
            recycling = new Recycling();
            recycling.recycleProduct(food);
            return true;
        }
        else return false;
    }
}
