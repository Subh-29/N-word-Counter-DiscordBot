package bot.Events;

import java.util.HashMap;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageEventListener extends ListenerAdapter{

    public static final HashMap<net.dv8tion.jda.api.entities.Member, Integer> nWordMap = new HashMap<>();

    @Override
 
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        String message = event.getMessage().getContentRaw().toLowerCase();
        String messageId = event.getMessageId();
        String userName = event.getMember().getUser().getName();
        System.out.println(userName + " User sentence: " + event.getMessage().getContentDisplay());
        if(!message.contains("gay")) {
            event.getChannel().addReactionById(messageId, Emoji.fromUnicode("U+1F308")).queue();

        }
        if(message.contains("nigga")) {
            if(!event.getMember().getUser().isBot()) {
                if(event.getMember() == null) {
                    event.getChannel().sendMessage("User is not in this server").queue();
                    return;
                }
                event.getChannel().addReactionById(messageId, Emoji.fromUnicode("U+1F5FF")).queue();
                int count = (message.split("nigga", -1).length - 1);
                nWordMap.put(event.getMember(), nWordMap.getOrDefault(event.getMember(), 0) + count);

            }
        }

    }

    public static int getNWordCount(net.dv8tion.jda.api.entities.Member memberID) {
        return nWordMap.getOrDefault(memberID, 0);
    }
    
}
