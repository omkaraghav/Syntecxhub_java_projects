import java.io.*;

public class Library {
    private final String FILE_NAME = "books.txt";

    public void addBook(Book book) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(book.toString());
            bw.newLine();
            System.out.println("Book added successfully.");
        } catch (IOException e) {
            System.out.println("Error adding book.");
        }
    }

    public void viewBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            System.out.println("\n----- BOOKS -----");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID: " + data[0]);
                System.out.println("Title: " + data[1]);
                System.out.println("Author: " + data[2]);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("No books available.");
        }
    }

    public void searchBook(String title) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[1].equalsIgnoreCase(title)) {
                    System.out.println("Book Found:");
                    System.out.println("ID: " + data[0]);
                    System.out.println("Title: " + data[1]);
                    System.out.println("Author: " + data[2]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Book not found.");
            }

        } catch (IOException e) {
            System.out.println("Error searching book.");
        }
    }

    public void removeBook(int id) {
        File input = new File(FILE_NAME);
        File temp = new File("temp.txt");

        boolean found = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {
                    found = true;
                    continue;
                }

                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error removing book.");
            return;
        }

        input.delete();
        temp.renameTo(input);

        if (found)
            System.out.println("Book removed successfully.");
        else
            System.out.println("Book not found.");
    }
}