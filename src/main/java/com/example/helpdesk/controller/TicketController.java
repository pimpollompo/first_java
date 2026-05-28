package com.example.helpdesk.controller;
import java.util.List;
import com.example.helpdesk.repository.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.helpdesk.model.Ticket;

@Controller
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public String tickets(Model model) {
        model.addAttribute("tickets",
                ticketRepository.findAllByOrderByCreatedAtDesc());
        return "tickets";
    }
    @GetMapping("/tickets/customer")
    public String getTicketsByCustomer(Model model) {

        List<Ticket> tickets = ticketRepository
                .findByCustomerNameContainingIgnoreCase("Иван");

        model.addAttribute("tickets", tickets);

        return "tickets";
    }
}
