package library_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Book\n2.Add User\n3.Show Books\n4.Issue\n5.Return\n6.Search\n7.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); 

            switch (ch) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    lib.addUser(new User(uid, name));
                    break;

                case 3:
                    lib.showBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int usid = sc.nextInt();

                    lib.issueBook(bid, usid);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    lib.returnBook(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter keyword: ");
                    sc.nextLine();
                    String key = sc.nextLine();

                    lib.search(key);
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}