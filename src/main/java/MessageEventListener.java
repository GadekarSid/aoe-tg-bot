import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;

public class MessageEventListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if(event.getChannel().getId().equals("933299509805600778")) {
            Message message = event.getMessage();
            //(event.getChannel().getHistoryFromBeginning(10).complete().getRetrievedHistory());
            List<Message> messageListRaw = event.getChannel().getHistory().retrievePast(100).complete();
            ArrayList<Message> messageList = new ArrayList<Message>(messageListRaw);
            Collections.reverse(messageList);
            for (Message m : messageList) {
                if (m.getAuthor().getName().equals("Pubobot")) {
                    if (!m.getEmbeds().isEmpty()) {
                        MessageEmbed messageEmbed = m.getEmbeds().get(0);
                        System.out.println("Embed title : " + messageEmbed.getTitle());
                        if(Objects.equals(messageEmbed.getTitle(), "__**Domestic** has started!__")){
                            String[] footerText = messageEmbed.getFooter().getText().split(":");
                            int matchId = Integer.valueOf(footerText[footerText.length-1].trim());
                            LocalDate dateCreated = m.getTimeCreated().toLocalDate();
                            System.out.println("Match ID : " +matchId);
                            System.out.println("Date created :" + dateCreated);
                            List<MessageEmbed.Field> fields = messageEmbed.getFields();
                            String[] playerIds = fields.get(0).getValue().split("\u200b");
                            List<String> team1Players = new ArrayList<>();
                            for(String playerId : playerIds){
                                playerId = playerId.replace("<","");
                                playerId = playerId.replace(">","");
                                playerId = playerId.replace("@","");
                                team1Players.add(playerId);
                            }
                            playerIds = fields.get(1).getValue().split("\u200b");
                            List<String> team2Players = new ArrayList<>();
                            for(String playerId : playerIds){
                                playerId = playerId.replace("<","");
                                playerId = playerId.replace(">","");
                                playerId = playerId.replace("@","");
                                team2Players.add(playerId);
                            }
                            String map = fields.get(3).getValue().replace("**","");
                            System.out.println("Map original value : " + fields.get(3).getValue());
                            System.out.println("Map : "+ map);
                        }
                    }
                    System.out.println("TG bot message : " + m.getContentDisplay());
                }
                //Use for 'message'

            }
        }
    }
}
