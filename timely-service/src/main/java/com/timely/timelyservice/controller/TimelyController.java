package com.timely.timelyservice.controller;
import java.util.List;

import com.timely.timelyservice.model.Timely;
import com.timely.timelyservice.model.dto.TimelyDTO;
import com.timely.timelyservice.service.ITimelyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TimelyController {

    @Autowired
    private ITimelyService timelyService;

    private HttpHeaders headers;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "timely/set-time-start", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setTimeStart(){

        final String status = timelyService.setTimeStart();

        return new ResponseEntity<>(status, headers, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "timely/set-time-stop", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setTimeStop(@Valid @RequestParam("id") Long id,
                                              @Valid @RequestParam("projectName") String projectName) throws Exception {

        final String status = timelyService.setTimeStop(id, projectName);

        return new ResponseEntity<>(status, headers, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "timely/project-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Timely>> getProjectStatus(){

        final List<Timely> timelyList = timelyService.getAll();

        return new ResponseEntity<>(timelyList, headers, HttpStatus.OK);
    }

    public static TimelyDTO convertToTimelyDTO(final Timely timely){

        TimelyDTO timelyDTO = new TimelyDTO();
        timelyDTO.setProject(timely.getProject());
        timelyDTO.setStart(timely.getStart());
        timelyDTO.setStop(timely.getStop());
        timelyDTO.setDuration(timely.getDuration());

        return  timelyDTO;
    }

}
