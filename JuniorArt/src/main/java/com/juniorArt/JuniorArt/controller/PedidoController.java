package com.juniorArt.JuniorArt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.juniorArt.JuniorArt.models.Pedidos;
import com.juniorArt.JuniorArt.models.Usuario;
import com.juniorArt.JuniorArt.repository.ClienteRepository;
import com.juniorArt.JuniorArt.repository.PedidoRepository;

@Controller
public class PedidoController {

	@Autowired
	private PedidoRepository pr;
	@Autowired
	private ClienteRepository cr;
	
	@RequestMapping(value="/formP", method=RequestMethod.GET)
	public String formularioPedidos() {
		return "JA/formPedidos";
	}
	
	@RequestMapping(value="/formP", method=RequestMethod.POST)
	public String pedidoCad(Pedidos pedido) {
		

		UseController uc =new UseController();
		String clienteNome = uc.getUsuario().getLogin();
		Usuario cliente = cr.findByLogin(clienteNome);
		pedido.setUsuario(cliente);
		pr.save(pedido);
		
		
		return "JA/formPedidos";
	}
	
	@RequestMapping("/pedidos")
	public ModelAndView listaPedidos() {
		ModelAndView mv = new ModelAndView("JA/listaPedidos");
		
		UseController uc =new UseController();
		
		Iterable<Pedidos> pedidos = pr.findByUsuario(uc.getUsuario());
		mv.addObject("pedidos", pedidos);
		return mv;
	
	}
	@RequestMapping("/todosPedidos")
	public ModelAndView todosPedidos() {
		ModelAndView mv = new ModelAndView("JA/ListaDelete");
		
		Iterable<Pedidos> pedidos = pr.findAll();
		mv.addObject("pedidos", pedidos);
		return mv;
	
	}
	@RequestMapping("/deletePedido")
	public String deletePedido(String nome) {
		
		Pedidos pedido= pr.findByNome(nome);
		pr.delete(pedido);
	return "redirect:/todosPedidos";
	
	}
}
