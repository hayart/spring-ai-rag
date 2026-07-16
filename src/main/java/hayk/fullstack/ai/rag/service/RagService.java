package hayk.fullstack.ai.rag.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class RagService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public RagService(
            ChatClient chatClient,
            VectorStore vectorStore
    ){
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
    }

    public String ask(
            String question
    ){
        return chatClient
                .prompt()
                .user(question)
                .advisors(
                        new QuestionAnswerAdvisor(
                                vectorStore
                        )
                )
                .call()
                .content();
    }
}
