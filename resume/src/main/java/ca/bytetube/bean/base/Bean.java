package ca.bytetube.bean.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ca.bytetube.beans.annotation.SQLSaveIgnore;
import ca.bytetube.beans.bean.SQLBean;

import java.util.Date;

public class Bean implements SQLBean {
    private Integer id;
    private Date createdTime;
    @SQLSaveIgnore
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @SQLSaveIgnore
    @JsonIgnore
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @JsonIgnore
    public String getJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this).replace("\"", "'");
    }
}
