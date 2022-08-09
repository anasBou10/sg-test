package com.sg.domain.transaction;

import java.math.BigDecimal;
import java.time.Instant;


public class Transaction {
    private String id;
    private Instant createdAt;
    private BigDecimal amount;
    private TransactionType type;
    private TransactionStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
