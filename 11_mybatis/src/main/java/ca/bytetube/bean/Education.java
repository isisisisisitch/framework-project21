package ca.bytetube.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ca.bytetube.bean.base.DateBean;

public class Education extends DateBean {
    private String name;
    private int type;
    private String intro;

    @JsonIgnore
    public String getTypeString() {
        switch (type) {
            case 1: return "College";
            case 2: return "Bachelor";
            case 3: return "Master";
            case 4: return "PhD";
            default: return "Others";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
