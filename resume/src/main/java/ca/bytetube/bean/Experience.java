package ca.bytetube.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ca.bytetube.bean.base.DateBean;

public class Experience extends DateBean {
    private String job;
    private String intro;
    private Company company;

    @JsonProperty("company.id")
    public Integer getCompanyId() {
        return company.getId();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @JsonIgnore
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
