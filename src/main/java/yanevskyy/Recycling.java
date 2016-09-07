package yanevskyy;

import java.util.Date;

/**
 * Recycles product.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Recycling {

    public void recycleProduct(Food food){
        food.setCreateDate(new Date());
    }
}
