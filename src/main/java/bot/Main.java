package bot;

import javax.security.auth.login.LoginException;

import bot.Events.Events;
import bot.Events.InteractionListener;
import bot.Events.MessageEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder jdaBuilder = JDABuilder.createDefault("YOUR_DISCORD_BOT_TOKEN");
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        JDA jda = jdaBuilder.addEventListeners(new Events(), new MessageEventListener(), new InteractionListener()).build();
        jda.upsertCommand("n-count", "Count any one's N word in this server").setGuildOnly(true).addOption(OptionType.MENTIONABLE, "tag", "null", true).queue();
    }
}