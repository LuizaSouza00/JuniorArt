package com.juniorArt.JuniorArt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juniorArt.JuniorArt.models.Usuario;



@Repository
public interface ClienteRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
