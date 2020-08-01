package com.dotin.dotintasktwo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_leave")
@Getter
@Setter
public class Leave extends Parent {


    @NotBlank(message = "Leave Subject is required")
    @Column(name = "c_leave_subject", nullable = false)
    private String leaveSubject;

    @NotBlank(message = "Leave Message is required")
    @Column(name = "c_leave_message", nullable = false)
    private String leaveMessage;

    @NotBlank(message = "is required")
    @Column(name = "c_leave_start")
    private String leaveFrom;

    @NotBlank(message = "is required")
    @Column(name = "c_leave_end")
    private String leaveTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_request_employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_leave_type")
    private CategoryElement leaveType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_leave_status")
    private CategoryElement leaveStatus;

}
