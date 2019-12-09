package com.juniorArt.JuniorArt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juniorArt.JuniorArt.models.Pedidos;
import com.juniorArt.JuniorArt.models.Usuario;

public interface PedidoRepository extends CrudRepository<Pedidos, String>{

	List<Pedidos> findByUsuario(Usuario usuario);
	Pedidos findByNome(String nome);
}
