package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;
import mk.finki.ukim.wp.lab.repository.MemoryEventRepository;
import mk.finki.ukim.wp.lab.repository.jpa.EventRepository;
import mk.finki.ukim.wp.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.findAllByNameAndAndDescription(text,text);
    }

    @Override
    public List<Event> searchEventByRating(String text, double rating) {
        return eventRepository.findAllByNameContainingIgnoreCaseAndPopularityScoreGreaterThanEqual(text, rating);
    }

    @Override
    public void addEvent(String name, String description, double popularityScore, Location location) {
        Event event = new Event(name, description, popularityScore, location);
        eventRepository.save(event);
    }

    @Override
    public void editEvent(long id, String name, String description, double popularityScore, Location location) {
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()){
            Event updateEvent = event.get();
            updateEvent.setName(name);
            updateEvent.setDescription(description);
            updateEvent.setPopularityScore(popularityScore);
            updateEvent.setLocation(location);
            eventRepository.save(updateEvent);
        }
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event findEventById(long id) {
        return eventRepository.findById(id).orElseGet(Event::new);
    }


}
