public enum PenguinMood {
    HAPPY ("Happy", "Images/HAPPY.PNG"),
    CRYING ("Crying", "Images/Crying.PNG"),
    HUNGRY ("Hungry", "Images/Hungry.PNG"),
    REALLY_HUNGRY ("Really Hungry", "Images/Hungry with rumbles.PNG"),
    TEAR ("Tear", "Images/Tear.PNG"),
    THIRSTY ("Thirsty", "Images/Thirsty with blush.PNG");


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
