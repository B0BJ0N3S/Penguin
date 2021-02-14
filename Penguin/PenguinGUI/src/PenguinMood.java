public enum PenguinMood {
  HAPPY("Happy", "Images/HAPPY.PNG"),
  CRYING("Crying", "Images/CRYING.PNG"),
  SUPER_HAPPY("Super Happy", "Images/SUPERHAPPY.PNG"),
  OKAY("Okay", "Images/OKAY.PNG"),
  SAD("Sad", "Images/SAD.PNG"),
  TEAR("Tear", "Images/TEAR.PNG");
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
