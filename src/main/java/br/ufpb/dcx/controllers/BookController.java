package br.ufpb.dcx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.ufpb.dcx.models.Book;
import br.ufpb.dcx.models.Usuario;
import br.ufpb.dcx.repository.BookRepository;
import br.ufpb.dcx.repository.UsuarioRepository;

@Controller
@RequestMapping("/books")
@SessionAttributes("roles")
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/create/")
	public ModelAndView formBook(Book book) {
		ModelAndView md = new ModelAndView("book/create");
		return md;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/create/")
	public String createBook(Book book) {
		bookRepo.save(book);
		return ("redirect:/books/");
	}
	
	//@Secured("ROLE_ADMIN")
	//@PreAuthorize("isAuthenticated()")
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView getAllBooks() {
		List<Book> books = bookRepo.findAll();
		Usuario usuario = getUserLogged();
		ModelAndView md = new ModelAndView("book/books");
		md.addObject("books", books);
		md.addObject("usuario", usuario);
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
	
	private Usuario getUserLogged(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioRepo.findByUsername(userDetails.getUsername());
        return usuario;
    }
}
