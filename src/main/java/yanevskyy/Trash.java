package yanevskyy;

/**
 * Uses as imitations the trash.
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Trash extends Storage {
    /**
     * Default constructor
     *
     * @param temperature
     */
    public Trash(int temperature) {
        super(temperature);
    }

    @Override
    public String toString() {
        return "Trash";
    }
}
