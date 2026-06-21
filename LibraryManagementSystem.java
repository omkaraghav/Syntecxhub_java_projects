import java.util.Scanner;

public class LibraryManagementSystem {
      public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Title: ");
                    library.searchBook(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int removeId = Integer.parseInt(sc.nextLine());
                    library.removeBook(removeId);
                    break;

                case 5:
                    System.out.println("Thank You");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
