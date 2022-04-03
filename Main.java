import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        String cityName = s.nextLine();

        String cityId = RequestSender.getCityId(cityName);

        // The 1st day
        System.out.println("In the " + cityName  + " " + RequestSender.getDate1(cityId) + " " + RequestSender.getWeatherTextDayAndNight1(cityId) + RequestSender.getMinAndMaxTemp1(cityId));
        // The 2nd day
        System.out.println("In the " + cityName  + " " + RequestSender.getDate2(cityId) + " " + RequestSender.getWeatherTextDayAndNight2(cityId) + RequestSender.getMinAndMaxTemp2(cityId));
        // The 3rd day
        System.out.println("In the " + cityName  + " " + RequestSender.getDate3(cityId) + " " + RequestSender.getWeatherTextDayAndNight3(cityId) + RequestSender.getMinAndMaxTemp3(cityId));
        // The 4th day
        System.out.println("In the " + cityName  + " " + RequestSender.getDate4(cityId) + " " + RequestSender.getWeatherTextDayAndNight4(cityId) + RequestSender.getMinAndMaxTemp4(cityId));
        // The 5th day
        System.out.println("In the " + cityName  + " " + RequestSender.getDate5(cityId) + " " + RequestSender.getWeatherTextDayAndNight5(cityId) + RequestSender.getMinAndMaxTemp5(cityId));

    }

}
