package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;

    public static List<String> sesii = null;
    public static List<Location> locations;


    @PostConstruct
    public void init() {

        events = new ArrayList<>();
        sesii = new ArrayList<>();
        locations = new ArrayList<>();

//        locations.add(new Location(1L, "City Center", "123 Main St", "500", "Central location for city events"));
//        locations.add(new Location(2L, "University Campus", "456 University Ave", "300", "Main campus area for students"));
//        locations.add(new Location(3L, "Sports Arena", "789 Arena Blvd", "1500", "Large arena for sports events"));
//        locations.add(new Location(4L, "Conference Hall", "101 Conference Rd", "250", "Hall for conferences and meetings"));
//        locations.add(new Location(5L, "Museum of Art", "202 Museum Ln", "200", "Popular location for art exhibits"));
//
//        events.add(new Event("Event1", "event1", 1, locations.get(0)));
//        events.add(new Event("Event2", "event2", 2, locations.get(1)));
//        events.add(new Event("Event3", "event3", 3, locations.get(2)));
//        events.add(new Event("Event4", "event4", 4, locations.get(3)));
//        events.add(new Event("Event5", "event5", 5, locations.get(4)));
//        events.add(new Event("Event6", "event6", 6, locations.get(0)));
//        events.add(new Event("Event7", "event7", 7, locations.get(1)));
//        events.add(new Event("Event8", "event8", 8, locations.get(2)));
//        events.add(new Event("Event9", "event9", 9, locations.get(3)));
//        events.add(new Event("Event10", "event10", 10, locations.get(4)));


    }


}
