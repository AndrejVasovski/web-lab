package mk.finki.ukim.wp.lab.repository;


import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MemoryEventRepository {

    public List<Event> findAll() {
        return DataHolder.events;

    }

    public List<Event> searchEvents(String text) {
        return DataHolder.events
                .stream()
                .filter(event -> text.contains(event.getName()) || text.contains(event.getDescription()))
                .toList();
    }

    public List<Event> searchEventByRating(String text, double rating) {
        return DataHolder.events
                .stream()
                .filter(event -> (text.contains(event.getName()) ||
                        text.contains(event.getDescription())) || event.getPopularityScore() >= rating)
                .toList();
    }

    public void addEvent(String name, String description, double popularityScore, Location location) {
        Event event = new Event(name, description, popularityScore, location);
        DataHolder.events.add(event);

    }

    public void editEvent(long id, String name, String description, double popularityScore, Location location) {
        Event event = DataHolder.events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow();
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);
    }
    public void deleteEvent(long id){

        Event event = DataHolder.events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow();
        DataHolder.events.remove(event);

    }


    public Event findEventById(long id) {

        return DataHolder.events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow();

    }




}
