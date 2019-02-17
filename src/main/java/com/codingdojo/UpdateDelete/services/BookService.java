package com.codingdojo.UpdateDelete.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.UpdateDelete.models.Book;
import com.codingdojo.UpdateDelete.repositories.BookRepository;

@Service
public class BookService {
	 	private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    // updates book????
		public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		
			Book bookInDB = bookRepository.findById(id).get();
			bookInDB.setTitle(title);
			bookInDB.setDescription(desc);
			bookInDB.setLanguage(lang);
			bookInDB.setNumberOfPages(numOfPages);
			return bookRepository.save(bookInDB);
			
		}
		// deletes book by ID
		public void deleteBook(Long id) {

			bookRepository.deleteById(id);
			
		}
		// updates book		
		public void updateBook(@Valid Book book) {
		
			
			bookRepository.save(book);
			
		}
}
