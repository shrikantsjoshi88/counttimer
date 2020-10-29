package timeinfo;

import configuration.Configuration;

public class TimeInfo {

    Configuration configuration = new Configuration();

    private String url;
    private String time;

    public TimeInfo()
    {
        this.url = configuration.getProperty(Configuration.URL);
        this.time = configuration.getProperty(Configuration.TIME);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
