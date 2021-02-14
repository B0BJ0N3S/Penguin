public enum PenguinMood {
    SUPER_HAPPY ("Super Happy", "L:/Penguin-main/FirstBuild/Images/SUPERHAPPY.PNG"),
    HAPPY ("Happy", "L:/Penguin-main/FirstBuild/Images/HAPPY.PNG"),
    OKAY ("Okay", "L:/Penguin-main/FirstBuild/Images/OKAY.PNG"),
    SAD ("Sad", "L:/Penguin-main/FirstBuild/Images/SAD.PNG"),
    TEAR ("Tear", "L:/Penguin-main/FirstBuild/Images/Tear.PNG"),
    CRYING ("Crying", "L:/Penguin-main/FirstBuild/Images/Crying.PNG");


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
