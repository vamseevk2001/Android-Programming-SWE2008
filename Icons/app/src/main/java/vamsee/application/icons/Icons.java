package vamsee.application.icons;

public class Icons {
    int iconId;
    String name;

    public Icons(int iconId, String name){
        this.iconId = iconId;
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public String getName() {
        return name;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
