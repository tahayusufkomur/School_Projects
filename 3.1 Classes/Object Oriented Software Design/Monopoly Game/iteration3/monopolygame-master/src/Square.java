import java.lang.reflect.InvocationTargetException;

public interface Square {

    int getPosition();
    void setOwner(Player player);
    Player getOwner();
    String getName();
    String getTypeName();
    boolean action(Player player, int dice, int index) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
    int getPrice();
    int getIndex(String name);
}