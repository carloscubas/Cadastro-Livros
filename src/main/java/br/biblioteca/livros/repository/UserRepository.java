package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.livros.entities.Login;

@Repository
public interface UserRepository extends JpaRepository<Login, String> {

	public Login findByUsername(String username);

}
