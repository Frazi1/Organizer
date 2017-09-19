package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/")
public class MainController {

    private final EventsRepository eventsRepository;

    @Autowired
    public MainController(EventsRepository eventsRepository) {
        Event e = new Event();
        e.setPerson("Valera");
        e.setDate(Date.from(Instant.now()));
        e.setDescription("test descr");
        this.eventsRepository = eventsRepository;
        eventsRepository.save(e);
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(){
//        StringBuilder s = new StringBuilder();
        StringBuffer s = new StringBuffer();
        Iterable<Event> eventIList =  eventsRepository.findAll();
        eventIList.forEach(event -> s.append(event.toString()));
        Logger logger = LoggerFactory.getLogger(MainController.class);
        logger.info(s.toString());

        return s.toString();
    }
}
