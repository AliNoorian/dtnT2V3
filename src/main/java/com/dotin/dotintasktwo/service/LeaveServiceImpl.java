package com.dotin.dotintasktwo.service;

import com.dotin.dotintasktwo.dao.LeaveRepository;
import com.dotin.dotintasktwo.entity.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    @Autowired
    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public List<Leave> findAll() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave findById(int Id) {
        Optional<Leave> result = leaveRepository.findById(Id);

        Leave leave;

        if (result.isPresent()) {
            leave = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find leave id - " + Id);
        }

        return leave;
    }

    @Override
    public void save(Leave leave) {
        leaveRepository.save(leave);
    }

    @Override
    public void deleteById(int Id) {
        leaveRepository.deleteById(Id);
    }
}
