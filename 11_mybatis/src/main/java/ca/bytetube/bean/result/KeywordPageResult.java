package ca.bytetube.bean.result;

public class KeywordPageResult<T> extends PageResult<T> {
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
