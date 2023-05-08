package com.madbarsoft.simplewebapp.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/book")
	public String index() {
		return bookService.helpMsg();
	}

	@GetMapping("/book/list")
	public List<BookEntity> getList() {
		return bookService.list();
	}

	@GetMapping("/book/find-by-id")
	public String findById(@RequestParam(name = "id") Long bookId) {
		return bookService.findById(bookId);
	}

	@GetMapping("/book/find-by-name")
	public String findByName(@RequestParam String name) {
		return bookService.findByName(name);
	}

	@GetMapping("/book/save")
	public String saveBook(@RequestParam String name, @RequestParam String type) {
		return bookService.bookSave(name, type);
	}

	@GetMapping("/book/update")
	public String updateBook(@RequestParam Long id, @RequestParam String name, @RequestParam String type) {
		return bookService.bookUpdate(id, name, type);
	}

	@GetMapping("/book/delete")
	public String bookDelete(@RequestParam Long id) {
		return bookService.bookDelete(id);
	}

}