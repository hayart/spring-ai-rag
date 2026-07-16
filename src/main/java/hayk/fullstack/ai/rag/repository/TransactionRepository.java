package hayk.fullstack.ai.rag.repository;

import hayk.fullstack.ai.rag.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


public interface TransactionRepository
        extends JpaRepository<Transaction,Long> {


    @Query("""
       SELECT COUNT(t)
       FROM Transaction t
       WHERE t.status='FAILED'
       AND DATE(t.createdAt)=CURRENT_DATE
    """)
    long countTodayFailed();


}
