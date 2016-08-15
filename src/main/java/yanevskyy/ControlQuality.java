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
        long timeExpiration = food.dateExpiration().getTime()- food.getCreateDate().getTime();
        long timeCurrent = new Date().getTime() - food.getCreateDate().getTime();
        long percentExpiration = calculationPercent(timeExpiration, timeCurrent);
        if (percentExpiration < 25)
            findStorage("Warehouse").getFoods().add(food);
        if (percentExpiration > 25 && percentExpiration < 75)
            findStorage("Shop").getFoods().add(food);
        if (percentExpiration > 75 && percentExpiration < 100) {
            food.setDiscount(50);
            findStorage("Shop").getFoods().add(food);
        }
        if (percentExpiration >= 100) findStorage("Trash").getFoods().add(food);
    }

    /**
     * Calculations percent used up time.
     * @param timeExpiration Fool expiration time.
     * @param timeCurrent Used up time.
     * @return
     */
    public long calculationPercent(long timeExpiration, long timeCurrent){

        return (timeCurrent * 100 / timeExpiration);
    }

    /**
     * Fins storage by name.
     * @param name Name Storage.
     * @return
     */
    public Storage findStorage(String name){
        for (Storage storage : getStorages()) {
            if(storage.toString().equals(name))
                return storage;
        }
        return null;
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
