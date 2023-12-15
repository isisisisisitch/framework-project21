package ca.bytetube.bean.result;

import ca.bytetube.bean.Contact;
import ca.bytetube.util.Times;

import java.util.Date;

public class ContactPageResult extends KeywordPageResult<Contact> {
    private Date beginDay;
    private Date endDay;
    /**
     * 2: 全部
     * 1: 已读
     * 0: 未读
     */
    private Integer type;

    public String getBeginDayString() {
        return Times.formatDate(beginDay);
    }
    public String getEndDayString() {
        return Times.formatDate(endDay);
    }

    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
