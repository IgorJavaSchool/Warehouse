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
    List<Storage> storages;

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
        for (Storage storage : getStorages()) {
            if (storage.checkQuality(food))
                storage.add(food);
        }

    }

    public List<Storage> getStorages() {
        return storages;
    }

    /**
     * Adds all storage.
     */
    public void fillStorage(){
        getStorages().add(new Shop());
        getStorages().add(new Trash());
        getStorages().add(new Warehouse());
    }
}
