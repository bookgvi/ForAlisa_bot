package BotSimple;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static Constants.ApiConstants.*;

public class BotSimple extends TelegramLongPollingBot {
    
    private TextHandler textHandler;

    public BotSimple() {
    }

    public BotSimple(TextHandler textHandler) {
        this.textHandler = textHandler;
    }

    @Override
    public String getBotUsername() {
        return "ForAlisa_bot";
    }

    @Override
    public String getBotToken() {
        return FOR_ALISA_BOT_TOKEN;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        String msg = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();
        String answer = textHandler.handler(msg);
        sendMsg(answer, chatId);
    }

    public void sendMsg(String msg, String chatId) {
        SendMessage newMsg = new SendMessage();
        newMsg.enableMarkdown(true);
        newMsg.setChatId(chatId);
        newMsg.setText(msg);
        try {
            execute(newMsg);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
