package yanevskyy;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses as parent class for all storage.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Storage {
    /*Foods on the storage*/
    List<Food> foods;

    /**
     * Default constructor
     */
    public Storage() {
        foods = new ArrayList<>();
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

}
