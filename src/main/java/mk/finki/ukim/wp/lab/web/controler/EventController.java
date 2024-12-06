package mk.finki.ukim.wp.lab.web.controler;


import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.EventBooking;
import mk.finki.ukim.wp.lab.model.Location;
import mk.finki.ukim.wp.lab.service.EventService;
import mk.finki.ukim.wp.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("events", eventService.listAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("error", error);
        return "listEvents";
    }

    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "add-event";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable long id, Model model) {
        try {

            Event event = eventService.findEventById(id);
            model.addAttribute("locations", locationService.findAll());
            model.addAttribute("event", event);
            return "add-event";
        }catch (Exception e){
            return "redirect:/events?error=EventNotFound";
        }

    }

    @PostMapping("/add")
    public RedirectView saveEvent(@RequestParam String name, @RequestParam String description, @RequestParam double popularityScore, @RequestParam long locationId) {
        Location location = locationService.findById(locationId);
        eventService.addEvent(name, description, popularityScore, location);
        return new RedirectView("/home");

    }

    @PostMapping("/edit/{id}")
    public String editEvent(@PathVariable Long id,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam double popularityScore,
                            @RequestParam long locationId) {
        Location location = locationService.findById(locationId);
        try {
            eventService.editEvent(id, name, description, popularityScore, location);

        } catch (Exception e) {
            return e.getMessage();
        }
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {

            try {

                    eventService.deleteEvent(id);

            } catch (Exception e) {
                return e.getMessage();

            }

        return "redirect:/events";

    }


}
