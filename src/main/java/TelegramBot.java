import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


public class TelegramBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
    }

    public String getBotUsername() {
        return "TelegramBot";
    }

    public String getBotToken() {
        return "707790172:AAFAYQobKGAN3aJSR--TOw2mCY5MbZBWU0M";
    }
}
