package me.funchy.penguinbot.utils;

public enum PermissionUtil {


    BANNED("Banned"),
    USR(""),
    GUILD_ADMIN(""),
    GUILD_OWNER(""),
    Bot("");
    private final String description;

    PermissionUtil(String description){
        this.description = description;
    }

    public static PermissionUtil findRank(String search) {
        for (PermissionUtil simpleRank : values()) {
            if (simpleRank.name().equalsIgnoreCase(search)) {
                return simpleRank;
            }
        }
        return null;
    }

    public boolean isAtLeast(PermissionUtil rank) {
        return this.ordinal() >= rank.ordinal();
    }

    public boolean isHigherThan(PermissionUtil rank) {
        return this.ordinal() > rank.ordinal();
    }

    public String getDescription() {
        return description;
    }

}
