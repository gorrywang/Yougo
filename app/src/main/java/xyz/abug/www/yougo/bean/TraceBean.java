package xyz.abug.www.yougo.bean;

/**
 * Created by iswgr on 2017/6/22.
 */

public class TraceBean {
    //时间
    private String time;
    private String data;

    public TraceBean(String time, String data) {
        this.time = time;
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
