package hey.forecast.entity;

import java.util.Arrays;

/**
 * Created by yhb on 17-12-14.
 */

public class HeWeather6 {
    Basic basic;
    DailyForecast[] daily_forecast;
    Hourly[] hourly;
    LifeStyle[] life_style;
    Now now;
    Update update;

    public Hourly[] getHourly() {
        return hourly;
    }

    public void setHourly(Hourly[] hourly) {
        this.hourly = hourly;
    }

    public LifeStyle[] getLife_style() {
        return life_style;
    }

    public void setLife_style(LifeStyle[] life_style) {
        this.life_style = life_style;
    }

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public DailyForecast[] getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(DailyForecast[] daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public Update getUpdate() {
        return update;
    }

    @Override
    public String toString() {
        return "HeWeather6{" +
                "basic=" + basic +
                ", daily_forecast=" + Arrays.toString(daily_forecast) +
                ", now=" + now +
                ", update=" + update +
                '}';
    }

    public void setUpdate(Update update) {
        this.update = update;
    }
}
