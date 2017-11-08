public class Factory {
    private static Factory instance;

    private Factory() {
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public GameState createState(String state) {
        if (state.equalsIgnoreCase("run"))
            return new Run();
        if (state.equalsIgnoreCase("win1"))
            return new Win1();
        if (state.equalsIgnoreCase("win2"))
            return new Win2();
        if (state.equalsIgnoreCase("menu"))
            return new Menu();
        if (state.equalsIgnoreCase("countdown"))
            return new CountDown();

        return null;

    }
}
