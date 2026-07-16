package hayk.fullstack.ai.rag.service;

import org.springframework.ai.document.Document;

import java.util.List;

public interface VectorService {

    void index(Document document);

    void index(List<Document> documents);

    List<Document> search(String query);

    List<Document> search(String query, int topK);

    List<Document> search(String query,
                          int topK,
                          String filterExpression);

}