package yanevskyy;

/**
 * Created by Y on 15.08.2016.
 */
public class Fridge extends Storage {
    /**
     * Default constructor
     *
     * @param temperature
     */
    public Fridge(int temperature) {
        super(temperature);
    }

    @Override
    public String toString() {
        return "Fridge";
    }
}
