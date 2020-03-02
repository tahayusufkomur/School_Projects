import java.lang.reflect.InvocationTargetException;

public class GoToJail implements Square {

    private int pos;
    private String name;
    private int jailIndex;  //Index of jail for sent player to the jail square
    private boolean controlGo;
    private String typeName = "Go To Jail Square";


    public GoToJail(String name, int pos, int jailIndex) {
        this.name = name;
        this.pos = pos;
        this.jailIndex= jailIndex;
        this.controlGo= controlGo();
    }

    public GoToJail() {

    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public void setOwner(Player player) {
    }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getIndex(String name) {
        for (int i = 0; i < 40; i++){
            if(GameCreation.squares.get(i).getName().equals(name))
                return i;
        }
        return 0;
    }

    @Override
	public boolean action(Player player, int dice, int index) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //Sent player to the Jail Square when it came to the Go To Jail Square
        player.setPosition(jailIndex);
        player.setJustCameJail(true);

		return false;
	}

    public boolean controlGo(){
        //Going to jail from goToJail square, player will not get goPrice
        //function returns false if jail square index is greater than goToJail square index

        if(this.pos < jailIndex)
            return false;

        return true;
    }
}
