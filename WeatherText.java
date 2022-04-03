import java.util.Objects;

public class WeatherText {

    private String weatherTextDay;
    private String weatherTextNight;

    public String getWeatherTextDay() {
        return weatherTextDay;
    }

    public void setWeatherTextDay(String weatherTextDay) {
        this.weatherTextDay = weatherTextDay;
    }

    public String getWeatherTextNight() {
        return weatherTextNight;
    }

    public void setWeatherTextNight(String weatherTextNight) {
        this.weatherTextNight = weatherTextNight;
    }

    public WeatherText(String weatherTextDay, String weatherTextNight) {
        this.weatherTextDay = weatherTextDay;
        this.weatherTextNight = weatherTextNight;
    }

    @Override
    public String toString() {
        return "it is expected " + weatherTextDay + " during the day, it is expected " + weatherTextNight + " at night, ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherText that = (WeatherText) o;
        return Objects.equals(weatherTextDay, that.weatherTextDay) && Objects.equals(weatherTextNight, that.weatherTextNight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherTextDay, weatherTextNight);
    }
}