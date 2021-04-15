import BotSimple.BotSimple;
import BotSimple.TextHandler;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main(String[] args) {
        try {
            TelegramBotsApi tgBotApi = new TelegramBotsApi(DefaultBotSession.class);
            TextHandler textHandler = new TextHandler();
            tgBotApi.registerBot(new BotSimple(textHandler));
        } catch(TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
