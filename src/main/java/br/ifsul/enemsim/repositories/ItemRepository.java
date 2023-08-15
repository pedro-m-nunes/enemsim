package br.ifsul.enemsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
