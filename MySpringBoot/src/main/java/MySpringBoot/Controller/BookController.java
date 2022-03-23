package MySpringBoot.Controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import MySpringBoot.Model.Book;
import MySpringBoot.Service.BookService;

@Component
@RestController
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	@RequestMapping("/book")
	public List<Book> all_books(){
		return bookService.getAllBooks();
	}
	
	
	@RequestMapping(value = {"/FindBook"})
	public String find_book(@RequestParam String bookName ){	
		return bookService.findBook(bookName);
	}
	
	
	@RequestMapping(value = {"/GetInfo", "/GetInfo/{name}"})
	public List<Book> getInfo(@PathVariable("name") String book){	
		return bookService.getInfo(book);
	}
	
	
	
	@RequestMapping(value = {"/DeleteBook", "/DeleteBook/{name}"})
	public List<Book> DeleteBook(@PathVariable("name") String book){	
		return bookService.deleteBook(book);
	}
	
	
	@PostMapping("/AddBook")
	public String AddBook(@Valid @RequestBody Book b, BindingResult bindingResult){	
		
		if(bindingResult.hasErrors()){
            return "them sach khong thanh cong";
        }
		bookService.addBook(b);
		return "them sach thanh cong" ;
	}
	
	
	@PostMapping(value = "/Update/{name}")
	public List<Book> Update(@PathVariable("name") String name, @RequestBody Book book){		
		return bookService.update(book);
	}
	
}
