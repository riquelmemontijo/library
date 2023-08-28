package com.library.services.email;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Email")
@Table(name = "email")
public class Email {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String subject;
    @Column(name = "sender")
    private String from;
    @Column(name = "recipient")
    private String to;
    @Transient
    private String content;
    @Enumerated(EnumType.STRING)
    private StatusEmail status;
    private LocalDateTime sendDate;

    public Email() {
    }

    public Email(String subject, String from, String to, String content) {
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public StatusEmail getStatus() {
        return status;
    }

    public void setStatus(StatusEmail status) {
        this.status = status;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }
}
