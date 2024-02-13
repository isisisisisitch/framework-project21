package ca.bytetube.bean.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ca.bytetube.util.Times;

import java.util.Date;

public class DateBean extends Bean {
    private Date beginDay;
    private Date endDay;

    public String getBeginDayYear() {
        return "" + Times.getYear(beginDay);
    }

    public String getBeginDayMonth() {
        return String.format("%02d", Times.getMonth(beginDay));
    }

    public String getEndDayYear() {
        return "" + Times.getYear(endDay);
    }

    public String getEndDayMonth() {
        return String.format("%02d", Times.getMonth(endDay));
    }

    @JsonProperty("beginDay")
    public String getBeginDayString() {
        return Times.formatDate(beginDay);
    }
    @JsonProperty("endDay")
    public String getEndDayString() {
        return Times.formatDate(endDay);
    }

    @JsonIgnore
    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }

    @JsonIgnore
    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }
}
