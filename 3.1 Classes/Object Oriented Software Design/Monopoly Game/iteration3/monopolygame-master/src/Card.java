public interface Card {
    void payCardAction(String text, int amount, Player player);
    void payPerPlayerCardAction(String text, int amount, Player player);
    void getOutOfJailCardAction(String text, Player player);
    void goToJailCardAction(String text, Player player);
    void goToCardAction(String text, String propertyName, Player player);
    void payPerBuildingCardAction(String text, int houseRepairAmount, int hotelRepairAmount, Player player);
}
