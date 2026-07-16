package hayk.fullstack.ai.rag.controller;

import hayk.fullstack.ai.rag.*;


import hayk.fullstack.ai.rag.dto.ChatRequest;
import hayk.fullstack.ai.rag.dto.ChatResponse;
import hayk.fullstack.ai.rag.service.RagService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/chat")
public class ChatController {


    private final RagService ragService;



    public ChatController(
            RagService ragService
    ){

        this.ragService = ragService;

    }




    @PostMapping
    public ChatResponse chat(
            @RequestBody ChatRequest request
    ){


        String answer =
                ragService.ask(
                        request.question()
                );



        return new ChatResponse(answer);

    }

}
