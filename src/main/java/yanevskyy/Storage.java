package yanevskyy;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses as parent class for all storage.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Storage {
    /*Foods on the storage*/
    private List<Food> foods;
    /*If storage is full then true*/
    private boolean full;
    /*Temperature on the storage*/
    private int temperature;
    /**
     * Default constructor
     */
    public Storage(int temperature) {
        this.foods = new ArrayList<>();
        this.full = false;
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
