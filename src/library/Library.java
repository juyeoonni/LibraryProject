package library;

import java.lang.reflect.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import book.*;
import loan.*;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;
    private Comparator<Loan> loanComparator;
    private DateTimeFormatter dateFormatter;
    private int loanPeriodInDays;
    private int extensionPeriodInDays;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.loanComparator = Comparator.comparing(Loan::getDueDate);
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.loanPeriodInDays = 14;
        this.extensionPeriodInDays = 7;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            LocalDate dueDate = LocalDate.now().plusDays(loanPeriodInDays);
            Loan loan = new Loan(book, member, dueDate);
            loans.add(loan);
            book.setAvailable(false);
            member.addLoan(loan);
            System.out.println(member.getName() + " borrowed " + book.getTitle() + ". Return by "
                    + dueDate.format(dateFormatter) + ".");
        } else {
            System.out.println(book.getTitle() + " is not available for borrowing.");
        }
    }

    public void returnBook(Loan loan) {
        if (loans.contains(loan)) {
            Book book = loan.getBook();
            Member member = loan.getMember();
            loans.remove(loan);
            book.setAvailable(true);
            member.removeLoan(loan);
            System.out.println(member.getName() + " returned " + book.getTitle() + ".");
        } else {
            System.out.println("Invalid loan.");
        }
    }

    public void extendLoan(Loan loan) {
        if (loans.contains(loan)) {
            LocalDate newDueDate = loan.getDueDate().plusDays(extensionPeriodInDays);
            loan.setDueDate(newDueDate);
            System.out.println("Loan extended. Return by " + newDueDate.format(dateFormatter) + ".");
        } else {
            System.out.println("Invalid loan.");
        }
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
public ArrayList<Book> getRecentBooks() {
    ArrayList<Book> recentBooks = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Book book : books) {
            if (currentDate.minusMonths(6).isBefore(book.getPublicationDate())) {
                recentBooks.add(book);
            }
        }
        return recentBooks;
    }

    public ArrayList<Loan> getLoanList() {
        if (loanComparator != null) {
            loans.sort(loanComparator);
        }
        return loans;
    }

    public void setLoanComparator(Comparator<Loan> comparator) {
        loanComparator = comparator;
    }

    public void setLoanPeriod(int days) {
        loanPeriodInDays = days;
    }

    public void setExtensionPeriod(int days) {
        extensionPeriodInDays = days;
    }
}
