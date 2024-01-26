import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordBot {
    public static void main(String[] args) {
        JDABuilder jdaBuilder = JDABuilder.createDefault("MTIwMDIxMjYwMjA4MTUyNTgzMA.GpuR2D.eil_Xl_VhYrI-9gk_x7lZXlv_vdkN3A_Q2X1ZY");
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        jdaBuilder.addEventListeners(new MessageEventListener()).build();
    }
}
