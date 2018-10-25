import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;


public class TelegramBot extends TelegramLongPollingBot {

    /* We don't want to commit these sorts of things to a public repository.
      Store them as environment variables.
     */
    private static final String TRELLO_API_KEY = System.getenv("TRELLO_API_KEY");
    private static final String TRELLO_API_TOKEN = System.getenv("TRELLO_API_TOKEN");
    private static final ObjectMapper mapper = new ObjectMapper();
    CloseableHttpClient client = HttpClientBuilder.create().build();


    public void onUpdateReceived(Update update) {

        //TODO: Examine text for tags
        String messageText = update.getMessage().getText();
        System.out.println(messageText);

        //TODO: Different methods for different actions?
        System.out.println(callTrello(messageText));

    }

    public String getBotUsername() {
        return "TelegramBot";
    }

    public String getBotToken() {
        return "707790172:AAFAYQobKGAN3aJSR--TOw2mCY5MbZBWU0M";
    }

    private JsonNode callTrello(String message){
        //TODO: Different URIs
//        String uri = "https://api.trello.com/1/members/me/boards?key="+TRELLO_API_KEY+"&token="+TRELLO_API_TOKEN;

        //This is just a test uri for now
        String uri = "https://jsonplaceholder.typicode.com/todos/1";

        HttpGet get = new HttpGet(uri);
        try {
            CloseableHttpResponse resp =  client.execute(get);
            return mapper.readTree(resp.getEntity().getContent());
        } catch (IOException e){
            //TODO: Deal with this
            return null;
        }
    }
}
