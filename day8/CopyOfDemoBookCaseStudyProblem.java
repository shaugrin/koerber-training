package day8;

import java.util.*;
import java.util.stream.Collectors;



public class CopyOfDemoBookCaseStudyProblem {

	public static void main(String[] args) {

		List<Book> allBooks = loadAllBooks();

		// 1. Find books with more then 400 pages
		List<Book>booksMoreThen400Pages=allBooks.stream()
				.filter(b-> b.getPages()>400).toList();
		
		// 2. Find all books that are java books and more then 400 pages
		List<Book>javaBooksMoreThen400Pages=allBooks.stream()
				.filter(b-> b.getSubject().equals(Subject.JAVA))
				.filter(b-> b.getPages()>400)
				.toList();
		
		// 3. We need the top three longest books
		List<Book>topThreeLongestBooks=allBooks.stream()
				.sorted(Comparator.comparing(Book::getPages).reversed())
				.limit(3)
				.toList();
	
		// 4. We need from the fourth to the last longest books
		List<Book>fourthToLastLongestBooks=allBooks.stream()
				.sorted(Comparator.comparing(Book::getPages).reversed())
				.skip(3)
				.toList();

		// 5. We need to get all the publishing years
		List<Integer>publishingYears=allBooks.stream()
				.distinct()
				.map(Book::getYear)
				.toList();

		// 6. We need all the authors names who have written a book
		List<String>authorsNames=allBooks.stream()
				.flatMap(b-> b.getAuthors().stream())
				.map(Author::getName)
				.distinct()
				.toList();
		
		// We need all the origin countries of the authors
		List<String>originCountries=allBooks.stream()
				.flatMap(b-> b.getAuthors().stream())
				.map(Author::getCountry)
				.distinct()
				.toList();

		// We want the most recent published book.
		List<Book>mostRecentPublishedBook=allBooks.stream()
				.sorted(Comparator.comparing(Book::getYear).reversed())
				.limit(1)
				.toList();
	
		// We want to know if all the books are written by more than one author
		List<Book>booksWrittenByMoreThanOneAuthor=allBooks.stream()
				.filter(b-> b.getAuthors().size()>1)
				.toList();
	
		// We want one of the books written by more than one author. (findAny)
		Book oneBookWrittenByMoreThanOneAuthor= allBooks.stream()
				.filter(b-> b.getAuthors().size()>100)
				.findAny()
				.orElse(null);
		
		// We want the total number of pages published.
		long totalNumberOfPagesPublished=allBooks.stream()
				.mapToLong(Book::getPages)
				.sum();

		// We want to know how many books are published in 2007
		List<Book>booksPublishedIn2007=allBooks.stream()
				.filter(b-> b.getYear()==2007)
				.toList();

	
		// We want to know how many pages the longest book has.
		int noOfPagesInlongestBooks= Objects.requireNonNull(allBooks.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null)).getPages();

	
		// We want the average number of pages of the books
		long averageNumberOfPagesPublished=allBooks.stream()
				.mapToLong(Book::getPages)
				.sum()/allBooks.size();
	
		// We want all the titles of the books
		List<String>bookTitles=allBooks.stream()
				.map(Book::getTitle)
				.toList();

	
		// We want the book with the higher number of authors?
		Book bookWithHigherNumberOfAuthors = allBooks.stream()
				.max(Comparator.comparingInt(book -> book.getAuthors().size()))
				.orElse(null);


		// We want a Map of book per year.
		Map<Integer, List<Book>> bookPerYear = allBooks.stream()
				.collect(Collectors.groupingBy(Book::getYear));

		

		// We want to count how many books are published per year.
		Map<Integer, Long> bookCountPerYear = allBooks.stream()
				.collect(Collectors.groupingBy(Book::getYear, Collectors.counting()));

		System.out.println(booksMoreThen400Pages);
		System.out.println(javaBooksMoreThen400Pages);
		System.out.println(topThreeLongestBooks);
		System.out.println(fourthToLastLongestBooks);
		System.out.println(publishingYears);
		System.out.println(authorsNames);
		System.out.println(originCountries);
		System.out.println(mostRecentPublishedBook);
		System.out.println(booksWrittenByMoreThanOneAuthor);
		System.out.println(oneBookWrittenByMoreThanOneAuthor);
		System.out.println(totalNumberOfPagesPublished);
		System.out.println(booksPublishedIn2007);
		System.out.println(noOfPagesInlongestBooks);
		System.out.println(averageNumberOfPagesPublished);
		System.out.println(bookTitles);
		System.out.println(bookWithHigherNumberOfAuthors);
		System.out.println(bookPerYear);
		System.out.println(bookCountPerYear);
	}

	private static List<Book> loadAllBooks() {
		List<Book> books = new ArrayList<>();
		List<Author> authors1 = Arrays.asList(new Author("raj", "gupta", "in"),
				new Author("ekta", "gupta", "in"));

		List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

		List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
				new Author("keshav", "gupta", "us"));

		books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
		books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
		books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));

		return books;
	}

}
