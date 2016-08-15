package yanevskyy;

/**
 * Uses as imitations the warehouse.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Warehouse extends Storage {
    /**
     * Default constructor
     *
     * @param temperature
     */
    public Warehouse(int temperature) {
        super(temperature);
    }

    @Override
    public String toString() {
        return "Warehouse";
    }
}
