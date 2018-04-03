package br.ufpb.dcx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpb.dcx.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findAll();
}
