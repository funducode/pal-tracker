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
        final TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        final TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);

        if(timeEntry==null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
    }

   @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
       final List<TimeEntry> timeEntries = timeEntryRepository.list();
       return new ResponseEntity<List<TimeEntry>>(timeEntries, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        TimeEntry updateEntry = timeEntryRepository.update(timeEntryId, expected);

        if(updateEntry==null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity<TimeEntry>(updateEntry, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(long timeEntryId) {
         timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }
}
