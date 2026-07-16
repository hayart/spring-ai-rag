package hayk.fullstack.ai.rag.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VectorServiceImpl implements VectorService {

    private final VectorStore vectorStore;

    @Override
    public void index(Document document) {

        log.info("Indexing document");

        vectorStore.add(List.of(document));
    }

    @Override
    public void index(List<Document> documents) {

        log.info("Indexing {} chunks", documents.size());

        vectorStore.add(documents);
    }

    @Override
    public List<Document> search(String query) {

        return search(query,5);
    }

    @Override
    public List<Document> search(String query,
                                 int topK) {

        SearchRequest request =
                SearchRequest.builder()
                        .query(query)
                        .topK(topK)
                        .build();

        return vectorStore.similaritySearch(request);
    }

    @Override
    public List<Document> search(String query,
                                 int topK,
                                 String filterExpression) {

        SearchRequest request =
                SearchRequest.builder()
                        .query(query)
                        .topK(topK)
                        .filterExpression(filterExpression)
                        .build();

        return vectorStore.similaritySearch(request);
    }


}
