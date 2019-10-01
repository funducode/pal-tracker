package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    TimeEntry timeEntry;
    List<TimeEntry> timeEntries;
    long id=1;

    public InMemoryTimeEntryRepository(){
        timeEntries = new ArrayList<TimeEntry>();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        this.timeEntry = timeEntry;
        this.timeEntry.setId(this.id++);
        timeEntries.add(this.timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        final Optional<TimeEntry> entry = timeEntries.stream().filter(c -> c.getId().equals(id)).findAny();
        return entry.isPresent()? entry.get(): null;
    }

    public List<TimeEntry> list() {
        return timeEntries;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        TimeEntry entry = this.find(id);

        // remove from the list
        if (timeEntries.indexOf(entry)>0)
        {    timeEntries.remove(timeEntries.indexOf(entry));

        this.timeEntry = timeEntry;
        this.timeEntry.setId(id);
        timeEntries.add(this.timeEntry);

        return this.timeEntry;
        }
        else {
         return null;
        }
    }

    public void delete(long id) {
        TimeEntry entry = this.find(id);
        timeEntries.remove(timeEntries.indexOf(entry));

    }

}
