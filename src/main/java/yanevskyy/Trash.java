package yanevskyy;

/**
 * Uses as imitations the trash.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Trash extends Storage {

    @Override
    public boolean checkQuality(Food food) {
        if (food.percentExpiration() >= 100)
            return true;
        else return false;
    }
}
