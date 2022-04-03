import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RequestSender {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final String API_KEY = "8wZ1C0CnmblCP7AN2YrKXhI1iFY1dxhh";

    public static String getCityId(String cityInText) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", cityInText)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String cityId = null;

        try {

            cityId = objectMapper.readTree(response.body().string())
                    .get(0)
                    .at("/Key")
                    .asText();

        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return cityId;
    }

    // The 1st day

    public static MinMaxTemp getMinAndMaxTemp1(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String maxTemp = null;
        String minTemp = null;

        try {

            maxTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Temperature/Maximum/Value")
                    .asText();


            minTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Temperature/Minimum/Value")
                    .asText();


        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return new MinMaxTemp(minTemp, maxTemp);

    }

    public static WeatherText getWeatherTextDayAndNight1(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String weatherTextDay = null;
        String weatherTextNight = null;

        try {

            weatherTextDay = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Day/IconPhrase")
                    .asText();

            weatherTextNight = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Night/IconPhrase")
                    .asText();

        } catch (IllegalStateException e) {

            System.out.println("Response in null");
            e.printStackTrace();

        }

        return new WeatherText(weatherTextDay, weatherTextNight);
    }

    public static String getDate1(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String date = null;

        try {

            date = objectMapper.readTree(response.body().string())
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Date")
                    .asText();

        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return date;
    }

    // The 2nd day

    public static MinMaxTemp getMinAndMaxTemp2(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String maxTemp = null;
        String minTemp = null;

        try {

            maxTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(1)
                    .at("/Temperature/Maximum/Value")
                    .asText();


            minTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(1)
                    .at("/Temperature/Minimum/Value")
                    .asText();


        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return new MinMaxTemp(minTemp, maxTemp);

    }

    public static WeatherText getWeatherTextDayAndNight2(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String weatherTextDay = null;
        String weatherTextNight = null;

        try {

            weatherTextDay = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(1)
                    .at("/Day/IconPhrase")
                    .asText();

            weatherTextNight = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(1)
                    .at("/Night/IconPhrase")
                    .asText();

        } catch (IllegalStateException e) {

            System.out.println("Response in null");
            e.printStackTrace();

        }

        return new WeatherText(weatherTextDay, weatherTextNight);
    }

    public static String getDate2(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String date = null;

        try {

            date = objectMapper.readTree(response.body().string())
                    .at("/DailyForecasts")
                    .get(1)
                    .at("/Date")
                    .asText();

        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return date;
    }

    // The 3rd day

    public static MinMaxTemp getMinAndMaxTemp3(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String maxTemp = null;
        String minTemp = null;

        try {

            maxTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(2)
                    .at("/Temperature/Maximum/Value")
                    .asText();


            minTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(2)
                    .at("/Temperature/Minimum/Value")
                    .asText();


        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return new MinMaxTemp(minTemp, maxTemp);

    }

    public static WeatherText getWeatherTextDayAndNight3(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String weatherTextDay = null;
        String weatherTextNight = null;

        try {

            weatherTextDay = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(2)
                    .at("/Day/IconPhrase")
                    .asText();

            weatherTextNight = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(2)
                    .at("/Night/IconPhrase")
                    .asText();

        } catch (IllegalStateException e) {

            System.out.println("Response in null");
            e.printStackTrace();

        }

        return new WeatherText(weatherTextDay, weatherTextNight);
    }

    public static String getDate3(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String date = null;

        try {

            date = objectMapper.readTree(response.body().string())
                    .at("/DailyForecasts")
                    .get(2)
                    .at("/Date")
                    .asText();

        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return date;
    }

    // The 4th day

    public static MinMaxTemp getMinAndMaxTemp4(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String maxTemp = null;
        String minTemp = null;

        try {

            maxTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(3)
                    .at("/Temperature/Maximum/Value")
                    .asText();


            minTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(3)
                    .at("/Temperature/Minimum/Value")
                    .asText();


        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return new MinMaxTemp(minTemp, maxTemp);

    }

    public static WeatherText getWeatherTextDayAndNight4(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String weatherTextDay = null;
        String weatherTextNight = null;

        try {

            weatherTextDay = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(3)
                    .at("/Day/IconPhrase")
                    .asText();

            weatherTextNight = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(3)
                    .at("/Night/IconPhrase")
                    .asText();

        } catch (IllegalStateException e) {

            System.out.println("Response in null");
            e.printStackTrace();

        }

        return new WeatherText(weatherTextDay, weatherTextNight);
    }

    public static String getDate4(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String date = null;

        try {

            date = objectMapper.readTree(response.body().string())
                    .at("/DailyForecasts")
                    .get(3)
                    .at("/Date")
                    .asText();

        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return date;
    }

    // The 5th day

    public static MinMaxTemp getMinAndMaxTemp5(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String maxTemp = null;
        String minTemp = null;

        try {

            maxTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(4)
                    .at("/Temperature/Maximum/Value")
                    .asText();


            minTemp = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(4)
                    .at("/Temperature/Minimum/Value")
                    .asText();


        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return new MinMaxTemp(minTemp, maxTemp);

    }

    public static WeatherText getWeatherTextDayAndNight5(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String weatherTextDay = null;
        String weatherTextNight = null;

        try {

            weatherTextDay = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(4)
                    .at("/Day/IconPhrase")
                    .asText();

            weatherTextNight = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(4)
                    .at("/Night/IconPhrase")
                    .asText();

        } catch (IllegalStateException e) {

            System.out.println("Response in null");
            e.printStackTrace();

        }

        return new WeatherText(weatherTextDay, weatherTextNight);
    }

    public static String getDate5(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String date = null;

        try {

            date = objectMapper.readTree(response.body().string())
                    .at("/DailyForecasts")
                    .get(4)
                    .at("/Date")
                    .asText();

        } catch (NullPointerException e) {

            System.out.println("Response is null");
            e.printStackTrace();

        }

        return date;
    }
}
