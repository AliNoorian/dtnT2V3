package com.dotin.dotintasktwo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "email")
@Data
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id", nullable = false)
    private int emailId;


    @Column(name = "subject_mail")
    private String subject;


    @Column(name = "message")
    private String message;


    @Column(name = "attachment")
    private String attachment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Employee senderEmployee;

    @ManyToMany(mappedBy = "receiverEmails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> receivers;



    public Email(String subject, String message, String attachment, Employee senderEmployee, List<Employee> receivers) {
        this.subject = subject;
        this.message = message;
        this.attachment = attachment;
        this.senderEmployee = senderEmployee;
        this.receivers = receivers;
    }

    public Email(int emailId, String subject, String message, String attachment, Employee senderEmployee) {
        this.emailId = emailId;
        this.subject = subject;
        this.message = message;
        this.attachment = attachment;
        this.senderEmployee = senderEmployee;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", attachment='" + attachment + '\'' +
                ", senderEmployee=" + senderEmployee +
                ", receivers=" + receivers +
                '}';
    }

}
