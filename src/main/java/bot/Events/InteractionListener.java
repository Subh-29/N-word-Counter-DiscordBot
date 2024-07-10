package bot.Events;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class InteractionListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("n-count")) {
            OptionMapping option = event.getOption("tag");
            Member memberId = option.getAsMember();
            if(memberId == null) {
                event.reply("User is not in this server").queue();
                return;
            }
            int count = MessageEventListener.getNWordCount(memberId);
            event.reply(memberId.getUser().getAsMention() + " has said the N word " + count + " times.").queue();
            
        }
    }
}
