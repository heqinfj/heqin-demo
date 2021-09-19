package com.heqin.placeholder.xml;

/**
 * @Author heqin
 * @Date 2021/9/12 13:03
 */
public class DataSource {

    private String url;

    private String userName;

    private String password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
