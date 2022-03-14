package com.timely.timelyservice.service;

import com.timely.timelyservice.model.Timely;

import java.util.List;

public interface ITimelyService {

    String setTimeStart();

    String setTimeStop(final Long id, final String projectName) throws Exception;

    List<Timely> getAll();
}
