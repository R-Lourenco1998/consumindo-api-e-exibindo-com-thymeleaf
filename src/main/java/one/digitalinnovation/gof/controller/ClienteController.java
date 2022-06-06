package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.StatusCliente;
import one.digitalinnovation.gof.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public ModelAndView index() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        ModelAndView mv = new ModelAndView("clientes/index");
        mv.addObject("clientes", clientes);
        return mv;
    }

    @GetMapping("/clientes/new")
    public ModelAndView nnew() {
        ModelAndView mv = new ModelAndView("clientes/new");
        mv.addObject("statusCliente", StatusCliente.values());
        return mv;
    }


}
