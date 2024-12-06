package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);

    List<Event> searchEventByRating(String text, double rating);

    void addEvent(String name, String description, double popularityScore, Location location);

    void editEvent(long id, String name, String description, double popularityScore, Location location);

    void  deleteEvent(long id);

    Event findEventById(long id);



}
