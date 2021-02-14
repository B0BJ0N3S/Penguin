public enum PenguinMood {
    SUPERHAPPY ("Super Happy", "Images/SUPERHAPPY.PNG"),
    HAPPY ("Happy", "Images/HAPPY.PNG"),
    OKAY ("Okay", "Images/OKAY.PNG"),
    SAD ("Sad", "Images/SAD.PNG"),
    TEAR ("Tear", "Images/Tear.PNG"),
    CRYING ("Crying", "Images/Crying.PNG");


    private String text, imagePath;

    public String getText() {
        return text;
    }

    public String getImagePath() {
        return imagePath;
    }

    PenguinMood(String text, String imagePath) {
        this.text = text;
        this.imagePath = imagePath;
    }
}
