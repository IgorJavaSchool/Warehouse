package yanevskyy;

import java.util.Date;

/**
 * Controls storage temperature and quality.
 * Created by Y on 15.08.2016.
 */
public class TemperatureControl extends ControlQuality {

    /**
     * Check the expiration time and the possible reproduction.
     * @param food Any product.
     */
    public void checkReproduct(Food food){
        long percentExpiration = calculationPercent(food);
        if (percentExpiration >= 100) {
            if (food.isCanReproduct()){
                food.setCreateDate(new Date().getTime());
                findFridge().getFoods().add(food);
            }
        }
    }

    public Storage findFridge(){
        for (Storage fridge : getStorages()) {
            if (fridge.getTemperature() < -4)
                return fridge;
        }
        return null;
    }
}
