package yanevskyy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Storage {
    List<Food> foods;

    public Storage() {
        foods = new ArrayList<>();
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Storage";
    }
}
