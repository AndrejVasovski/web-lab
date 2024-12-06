package mk.finki.ukim.wp.lab.web.controler;



import mk.finki.ukim.wp.lab.model.EventBooking;
import mk.finki.ukim.wp.lab.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {
    private final EventBookingService eventBookingService;

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    @PostMapping()
    public String getEventBookingPage(@RequestParam(required = false) String error,
                                      @RequestParam String selectedEvent,
                                      @RequestParam int numTickets,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        EventBooking booking = eventBookingService.placeBooking(selectedEvent, " ", " ", numTickets);

        model.addAttribute("booking", booking);

        return "bookingConfirmation";
    }
}
