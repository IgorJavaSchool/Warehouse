package yanevskyy;

/**
 * Uses as imitations the shop.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Shop extends Storage {
    /**
     * Default constructor
     *
     * @param temperature
     */
    public Shop(int temperature) {
        super(temperature);
    }

    @Override
    public String toString() {
        return "Shop";
    }
}
