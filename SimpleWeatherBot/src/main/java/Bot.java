import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.sql.*;

/**
 * @author Evgeniy Govorushkin
 * @version 1.0
 */

public class Bot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            String command = update.getMessage().getText();
            Message message = update.getMessage();
            SendMessage sendMessage = new SendMessage();
            long chat_id = update.getMessage().getChatId();
            String weatherResponse = "";

            if (message.hasLocation()) {
                //ответ с текущей погодой
                try {
                    weatherResponse = Weather.getInstance().currentWeather(message.getLocation().getLatitude(),
                            message.getLocation().getLongitude());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                sendMessage.setText(weatherResponse);
                sendMessage.setChatId(chat_id);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                //ответ с прогнозом погоды на ближайшие сутки
                try {
                    weatherResponse = Weather.getInstance().forecastWeather(message.getLocation().getLatitude(),
                            message.getLocation().getLongitude());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                sendMessage.setText(weatherResponse).setChatId(chat_id);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                //запись в БД
                Database database = new Database();
                try {
                    database.writeToDb(message.getChatId(),
                            message.getChat().getUserName(),
                            message.getChat().getFirstName(),
                            message.getChat().getLastName(),
                            message.getLocation().getLatitude(),
                            message.getLocation().getLongitude());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                sendMessage.setChatId(chat_id).setText("Thanks for subscribe!!!");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                //help
            } else if (command.equals("/help")) {
                sendMessage.setChatId(chat_id).setText("Отправьте свое текущее местоположение " +
                        "для получения текущей погоды и прогноза погоды на ближайшие сутки.\n \n" +
                        "Доступные команды:\n/help - вызов справки\n/subscribe - подписка на прогноз погоды\n" +
                        "/unsubscribe - отписка от прогноза погоды");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                //подписка на прогноз погоды
            } else if (command.equals("/subscribe")) {
                sendMessage.setChatId(chat_id).setText("Вы успешно подписались на рассылку прогноза погоды");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                // отписка от прогноза погоды
            } else if (command.equals("/unsubscribe")) {
                Database database = new Database();
                try {
                    database.deleteFromDb(chat_id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sendMessage.setChatId(chat_id).setText("Вы отписались от рассылки.");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public String getBotUsername() {
        return "weather_bot";
    }

    public String getBotToken() {
        return "564927822:AAGG58SwW76YumhRpe2vwRyhLRviYTutZ4M";
    }


}
