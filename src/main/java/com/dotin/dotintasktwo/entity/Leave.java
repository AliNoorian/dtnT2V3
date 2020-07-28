package com.dotin.dotintasktwo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "leave_table")
@Data
public class Leave {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "leave_id",nullable = false)
    private int leaveId;

    @NotBlank(message="Leave Subject is required")
    @Column(name = "leave_subject",nullable = false)
    private String leaveSubject;

    @NotBlank(message="Leave Message is required")
    @Column(name = "leave_message",nullable = false)
    private String leaveMessage;

    @NotBlank(message = "is required")
    @Column(name = "leave_start")
    @Temporal(TemporalType.DATE)
    private Date leaveFrom;

    @NotBlank(message = "is required")
    @Column(name = "leave_end")
    @Temporal(TemporalType.DATE)
    private Date leaveTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_type")
    private CategoryElement leaveType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_status")
    private CategoryElement leaveStatus;

    public Leave(@NotBlank(message = "Leave Subject is required") String leaveSubject,
                 @NotBlank(message = "Leave Message is required") String leaveMessage,
                 @NotBlank(message = "is required") Date leaveFrom,
                 @NotBlank(message = "is required") Date leaveTo, Employee employee,
                 CategoryElement leaveType, CategoryElement leaveStatus) {
        this.leaveSubject = leaveSubject;
        this.leaveMessage = leaveMessage;
        this.leaveFrom = leaveFrom;
        this.leaveTo = leaveTo;
        this.employee = employee;
        this.leaveType = leaveType;
        this.leaveStatus = leaveStatus;
    }

    public Leave(int leaveId, @NotBlank(message = "Leave Subject is required") String leaveSubject,
                 @NotBlank(message = "Leave Message is required") String leaveMessage,
                 @NotBlank(message = "is required") Date leaveFrom,
                 @NotBlank(message = "is required") Date leaveTo, Employee employee) {
        this.leaveId = leaveId;
        this.leaveSubject = leaveSubject;
        this.leaveMessage = leaveMessage;
        this.leaveFrom = leaveFrom;
        this.leaveTo = leaveTo;
        this.employee = employee;
    }



    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", leaveSubject='" + leaveSubject + '\'' +
                ", leaveMessage='" + leaveMessage + '\'' +
                ", leaveFrom=" + leaveFrom +
                ", leaveTo=" + leaveTo +
                ", employee=" + employee +
                ", leaveType=" + leaveType +
                ", leaveStatus=" + leaveStatus +
                '}';
    }
}
