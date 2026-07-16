package hayk.fullstack.ai.rag.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name="transactions")
@Data
public class Transaction {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;


    private String atmId;


    private BigDecimal amount;


    private String status;


    private LocalDateTime createdAt;

}
