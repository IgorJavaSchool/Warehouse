package yanevskyy;

import java.util.List;

/**
 * Uses as parent class for all storage.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public abstract class Storage {
    /*Foods on the storage*/
    private List<Food> foods;
    /*It shows free space in the warehouse.*/
    private boolean fullStorage;
    /**
     * Default constructor
     */
    public Storage(List<Food> foods, boolean fullStorage) {
        this.foods = foods;
        this.fullStorage = fullStorage;
    }

    protected boolean isFullStorage() {
        return fullStorage;
    }

    public void add(Food food){
        foods.add(food);
    }

    public abstract boolean checkQuality(Food food);

}
