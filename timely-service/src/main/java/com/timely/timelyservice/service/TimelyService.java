package com.timely.timelyservice.service;

import com.timely.timelyservice.model.Timely;
import com.timely.timelyservice.repository.TimelyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Service
public class TimelyService implements ITimelyService{

    private static final  String SUCCESS = "SUCCESS";

    @Autowired
    private TimelyRepository timelyRepository;

    @Override
    public String setTimeStart(){

        Timely timely = new Timely();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timely.setStart(timestamp);

        timelyRepository.save(timely);

        return SUCCESS;
    }

    @Override
    public String setTimeStop(final Long id, final String projectName) throws Exception {

        Timely timely = timelyRepository.findById(id).orElse(null);

        if (timely == null){
            throw new Exception("Cannot find project with Id " + id);
        } else {

            timely.setProject(projectName);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            timely.setStop(timestamp);

            long diff = timely.getStop().getTime() - timely.getStart().getTime();

            timely.setDuration(diff);

            timelyRepository.save(timely);
        }

        return SUCCESS;
    }

    @Override
    public List<Timely> getAll(){

        List<Timely> timely = new ArrayList<>();

        timelyRepository.findAll().forEach(timely::add);

        return timely;
    }
}
