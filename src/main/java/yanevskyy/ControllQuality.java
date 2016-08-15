package yanevskyy;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class ControllQuality implements InspectionQuality {
    List<Storage> storages;

    public ControllQuality() {
        this.storages = new ArrayList<>();
    }

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
            food.setDisscount(50);
            findStorage("Shop").getFoods().add(food);
        }
        if (percentExpiration >= 100) findStorage("Trash").getFoods().add(food);
    }

    public long calculationPercent(long timeExpiration, long timeCurrent){

        return (timeCurrent * 100 / timeExpiration);
    }

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

    public void fillStorage(){
        getStorages().add(new Shop());
        getStorages().add(new Trash());
        getStorages().add(new Warehouse());
    }
}
