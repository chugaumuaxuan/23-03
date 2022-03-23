package MySpringBoot.Model;

import javax.validation.constraints.NotBlank;


public class Book {
	
	@NotBlank(message = "Khong duoc bo trong")
	private String bookName;
	
	private long pagesNumber;
	
	public Book(String bookName, long pagesNumber){
		this.bookName = bookName;
		this.pagesNumber = pagesNumber;
	}
	
	public Book() {
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public long getPagesNumber() {
		return pagesNumber;
	}
	public void setPagesNumber(long pagesNumber) {
		this.pagesNumber = pagesNumber;
	}
	
	
}
