import java.util.Date;
import java.util.TimerTask;

/**
 * @author Evgeniy Govorushkin
 * @version 1.0
 */

public class WeatherShedule extends TimerTask {
    @Override
    public void run() {
        System.out.println("Начинается рассылка погоды." + new Date());
        sendWeather();
        System.out.println("Рассылка погоды окончена" + new Date());
        System.out.println("-------------------------------------------------------");
    }

    private void sendWeather(){
//
//        Database database = new Database();
//
//        try {
//            database.readLatitude(chat_id);
//            database.readLongitude(chat_id);
//            System.out.println(database.readLatitude(chat_id));
//            System.out.println(database.readLongitude(chat_id));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            try {
//                weatherResponse = Weather.getInstance().currentWeather(database.readLatitude(chat_id),database.readLongitude(chat_id));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        sendMessage.setText(weatherResponse);
//        sendMessage.setChatId(chat_id);
    }
}


