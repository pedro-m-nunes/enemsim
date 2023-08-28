package br.ifsul.enemsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.enemsim.entidades.relacionais.ProvaItem;

public interface ProvaItemRepository extends JpaRepository<ProvaItem, Integer> {

}
