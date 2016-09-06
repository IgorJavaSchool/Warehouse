package yanevskyy;

import java.util.List;

/**
 * Uses as imitations the trash.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Trash extends Storage {

    /**
     * Default constructor
     *
     * @param foods
     */
    public Trash(List<Food> foods, boolean fullStorage) {
        super(foods, fullStorage);
    }

    @Override
    public boolean checkQuality(Food food) {
        if (food.percentExpiration() >= 100 && !food.isCanReproduct())
            return true;
        else return false;
    }
}
