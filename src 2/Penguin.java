public class Penguin {
    public static PenguinMood mood;
    public static String name;
    public static Homework[] homeworks;
    public static Waterbar waterbar;
    private static int waterLevel = 0;

    Penguin() {
        mood = PenguinMood.OKAY;
        name = "Bill";
    }

    public int getMoodLevel() {
        return 3;
    }

    public void drinkWater() {
        waterLevel++;
    }

    public double getWaterLevel() {
        return (double) waterLevel;
    }
}
