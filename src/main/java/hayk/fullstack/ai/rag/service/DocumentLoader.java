package hayk.fullstack.ai.rag.service;


import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentLoader {
    private final VectorStore vectorStore;
    public DocumentLoader(
            VectorStore vectorStore
    ){
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void load()
            throws Exception {
        Resource[] files =
                new PathMatchingResourcePatternResolver()
                        .getResources(
                                "classpath:/docs/*.pdf"
                        );
        TokenTextSplitter splitter =
                new TokenTextSplitter();
        for(Resource file: files){
            PagePdfDocumentReader reader =
                    new PagePdfDocumentReader(file);
            List<Document> documents =
                    splitter.apply(
                            reader.get()
                    );
            vectorStore.add(documents);
            System.out.println(
                    "Loaded PDF: "
                            + file.getFilename()
            );
        }
    }
}
