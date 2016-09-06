package yanevskyy;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Uses for check the expiration date and move to storage.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class ControlQuality implements InspectionQuality {
    /*All storage*/
    private List<Storage> storages;

    /**
     * Default constructor
     */
    public ControlQuality() {
        this.storages = new ArrayList<>();
    }

    /**
     * Checks Food's data expiration and move it to storage.
     * @param food Any food.
     */
    @Override
    public void checkQuality(Food food) {
        for (Storage storage : this.storages) {
            if (storage.checkQuality(food))
                storage.add(food);
        }

    }

    /**
     * Adds all storage.
     */
    public void addStorage(Storage storage){
        this.storages.add(storage);
    }
}
