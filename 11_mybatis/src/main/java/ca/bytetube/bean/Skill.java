package ca.bytetube.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ca.bytetube.bean.base.Bean;

public class Skill extends Bean {
    private String name;

    private Integer level;

    @JsonIgnore
    public String getLevelString() {
        switch (level) {
            case 1: return "junior";
            case 2: return "medium";
            case 3: return "master";
            default: return "entry";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", level=" + level +
                ", createdTime=" + getCreatedTime() +
                '}';
    }
}
