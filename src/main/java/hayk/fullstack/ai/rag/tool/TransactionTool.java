package hayk.fullstack.ai.rag.tool;

import org.springframework.ai.tool.annotation.Tool;

import org.springframework.stereotype.Component;


import hayk.fullstack.ai.rag.repository.TransactionRepository;


@Component
public class TransactionTool {


    private final TransactionRepository repository;


    public TransactionTool(
            TransactionRepository repository
    ){
        this.repository = repository;
    }



    @Tool(
            description =
                    "Returns number of failed ATM transactions today"
    )
    public long getFailedTransactionsToday(){


        return repository
                .countTodayFailed();

    }

}
