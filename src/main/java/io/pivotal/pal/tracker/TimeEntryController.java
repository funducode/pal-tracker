package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(TimeEntry timeEntryToCreate) {
        timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<TimeEntry>(timeEntryToCreate, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        return new ResponseEntity<TimeEntry>(timeEntryRepository.find(timeEntryId), HttpStatus.OK);
    }

   @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
       return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        return new ResponseEntity<TimeEntry>(timeEntryRepository.update(timeEntryId, expected), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(long timeEntryId) {
         timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<TimeEntry>(HttpStatus.OK);
    }
}
