package mk.finki.ukim.wp.lab.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import mk.finki.ukim.wp.lab.service.EventService;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EventRepository", urlPatterns = "/home")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;


    private final SpringTemplateEngine springTemplateEngine;

    public EventListServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);


        String text = req.getParameter("text");
        String rating = req.getParameter("rating");
        try {
            System.out.println(rating);
            double number = Double.parseDouble(rating);
            if (text != null) {
                context.setVariable("events", eventService.searchEventByRating(text,number));
            } else {
                context.setVariable("events", eventService.listAll());
            }



        } catch (Exception e) {
            if (text != null) {
                context.setVariable("events", eventService.searchEvents(text));
            } else {
                context.setVariable("events", eventService.listAll());
            }

        }

        String id =req.getSession().getId();
        if(!DataHolder.sesii.contains(id)){
            DataHolder.sesii.add(id);

        }
        context.setVariable("userViews",DataHolder.sesii.size());






        springTemplateEngine.process("listEvents.html", context, resp.getWriter());


    }


}
