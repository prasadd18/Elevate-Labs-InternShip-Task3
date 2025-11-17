import java.util.*;
class Book 
{
	private int id;
	private String title;
	private String author;
	private boolean isIssued;
	
	public Book(int id,String title,String author)
	{
		this.id=id;
		this.title=title;
		this.author=author;
		this.isIssued=false;
	}
	public boolean issueBook()
	{
		if(!isIssued)
		{
			isIssued=true;
			return true;
		}
		return false;
	}
	public boolean returnBook()
	{
		if(isIssued) 
		{ 
            isIssued=false;
            return true;
        }
        return false;
	}
	public int getId()
	{
		return id;
	}
	public String toString()
	{
		return id+" - "+title+" BY "+author+(isIssued ? " ISSUED":" NOT ISSUED");
	}
}

class User
{
	private int userId;
	private String name;
	private List<Book> issuedBooks;
	public User(int userId,String name)
	{
		this.userId=userId;
		this.name=name;
		this.issuedBooks=new ArrayList<Book>();
	}
	public boolean issueBook(Book book)
	{
		 if(book.issueBook()) {
	            issuedBooks.add(book);
	            return true;
	        }
	        return false; 
	}
	public boolean returnBook(Book book)
	{
		 if (book != null && issuedBooks.contains(book))
		 {
	            if (book.returnBook()) 
	            {
	                issuedBooks.remove(book);
	                return true;
	            }
		 }
		 return false;
	}
	public int getUserId()
	{
		return userId;
	}
	public String toString()
	{
		return "User: " +userId+" - "+name+ " | Books Issued: "+issuedBooks.size();
	}
}

class Library
{
	private List<Book>Books;
	private List<User>Users;
	public Library()
	{
		this.Books=new ArrayList<>();
		this.Users=new ArrayList<>();
	}
	public void addBook(Book book)
	{
		Books.add(book);
	}
	public void addUser(User user)
	{
		Users.add(user);
	}
	public boolean issueBook(int bookId,int userId)
	{
		Book book=findBook(bookId);
		User user=findUser(userId);
		if(book!=null&&user!=null)
		{
			return user.issueBook(book);
		}
		return false;
	}
	public boolean returnBook(int bookId,int userId)
	{
		Book book = findBook(bookId);
        User user = findUser(userId);
        if (book != null && user != null) {
            return user.returnBook(book);
        }
        return false;
	}
	private Book findBook(int id) {
	    for (Book b : Books)
	    {
	        if (b.getId() == id)
	        {  
	            return b;
	        }
	    }
	    return null;
	}

	private User findUser(int id) {
	    for (User u:Users) {
	        if (u.getUserId() == id) {
	            return u;
	        }
	    }
	    return null;
	}

	public void showBooks()
	{
		if(!Books.isEmpty())
		{
			for(Book b:Books)
			{
				System.out.println(b);
			}
		}
		else
		{
			System.out.println("There is No Books Available in Library");
		}
		
	}
}

class Main
 {
    public static void main(String[] args)
 {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library Menu =====");
            System.out.println("1. Show all books");
            System.out.println("2. Add a book");
            System.out.println("3. Add a user");
            System.out.println("4. Issue a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); //newline
            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    System.out.println("Book added successfully!");
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.addUser(new User(userId, name));
                    System.out.println("User added successfully!");
                    break;
                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int issueUserId = sc.nextInt();
                    if (library.issueBook(issueBookId, issueUserId)) {
                        System.out.println("Book issued successfully!");
                    } else {
                        System.out.println("Book issue failed (maybe already issued or invalid IDs).");
                    }
                    break;
                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int returnUserId = sc.nextInt();
                    if (library.returnBook(returnBookId, returnUserId)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book return failed (maybe not issued or invalid IDs).");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Library System. Goodbye!");
                    sc.close();
                    System.exit(0);
                    default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


