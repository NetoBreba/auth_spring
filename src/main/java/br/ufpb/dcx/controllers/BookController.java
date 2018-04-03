package br.ufpb.dcx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ufpb.dcx.models.Book;
import br.ufpb.dcx.repository.BookRepository;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/create/")
	public ModelAndView formBook(Book book) {
		ModelAndView md = new ModelAndView("book/create");
		return md;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/create/")
	public String createBook(Book book) {
		System.out.println(book.getTitle());
		bookRepo.save(book);
		return ("redirect:/books/");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView getAllBooks() {
		List<Book> books = bookRepo.findAll();
		ModelAndView md = new ModelAndView("book/books");
		md.addObject("books", books);
		return md;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/update/{id}/")
	public ModelAndView formUpdateBook(@PathVariable("id") Long id) {
		Book book = bookRepo.findOne(id);
		ModelAndView md = new ModelAndView("book/update");
		md.addObject("book", book);
		return md;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/update/{id}/")
	public String updateBook(@PathVariable("id") Long id, Book book) {
		book.setId(id);
		bookRepo.save(book);
		return ("redirect:/books/");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}/")
	public String deleteBook(@PathVariable("id") Long id) {
		bookRepo.delete(id);
		return ("redirect:/books/");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/")
	public ModelAndView getBook(@PathVariable("id") Long id) {
		Book book = bookRepo.findOne(id);
		ModelAndView md = new ModelAndView("book/book");
		md.addObject("book", book);
		return md;
	}
}
