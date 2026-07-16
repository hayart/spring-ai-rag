package hayk.fullstack.ai.rag.config;

import hayk.fullstack.ai.rag.tool.TransactionTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AiConfig {

    @Bean
    ChatClient chatClient(
            ChatClient.Builder builder
    ){
        return builder.build();
    }

    @Bean
    ChatClient chatClient(
            ChatClient.Builder builder,
            TransactionTool transactionTool
    ){

        return builder
                .defaultTools(transactionTool)
                .build();

    }

}
