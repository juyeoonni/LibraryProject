package csv;

import java.util.ArrayList;
import java.util.List;

import book.*;
import loan.*;
import member.*;

public class Exportlist {
	
	CSVWriter csvwriter = new CSVWriter();

	public void exportMember(List<MemberValue> memberlist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"memberID", "name","age", "address", "phoneNumber", "dateOfBirth", "dateOfMembership"};
		export.add(index);
		for(int i=0; i<memberlist.size(); i++) {
			String[] member = new String[6];
			member[0] = memberlist.get(i).getMemberID();
			member[1] = memberlist.get(i).getName();
			member[2] = String.valueOf(memberlist.get(i).getAge());
			member[2] = memberlist.get(i).getAddress();
			member[3] = memberlist.get(i).getPhoneNumber();
			member[4] = memberlist.get(i).getDateOfBirth();
			member[5] = memberlist.get(i).getDateOfMembership();
			export.add(member);
		}
		csvwriter.writeCSV(export, "member.csv");
	}
	
	
//  public Book(String isbn, String title, String author, String publisher, String publicationDate, boolean isAvailable)
	
	public void exportBook(List<Book> booklist) {
		List<String[]> export = new ArrayList<>();
		String[] index = {"isbn", "title", "author", "publisher", "publicationDate", "isAvailable"};
		export.add(index);
		for(int i=0; i<booklist.size(); i++) {
			String[] book = new String[5];
			book[0] = booklist.get(i).getIsbn();
			book[1] = booklist.get(i).getTitle();
			book[2] = booklist.get(i).getAuthor();
			book[3] = booklist.get(i).getPublicationDate();
			book[4] = String.valueOf(booklist.get(i).isAvailable());
			// (Boolean.valueOf((l.get(3))))
			export.add(book);
		}
		csvwriter.writeCSV(export, "book.csv");
	}
	
//	public void exportLoan(List<Loan> loanlist) {
//		List<String[]> export = new ArrayList<>();
//		String[] index = {"id", "memberName", "bookTitle", "renewStatus" , "loanDate", "deadline", "extension"};
//		export.add(index);
//		for(int i=0; i<loanlist.size(); i++) {
//			String[] loan = new String[7];
//			loan[0] = String.valueOf(loanlist.get(i).getId());
//			loan[1] = loanlist.get(i).getMemberName();
//			loan[2] = loanlist.get(i).getBookTitle();
//			loan[3] = String.valueOf(loanlist.get(i).isRenewStatus());
//			loan[4] = loanlist.get(i).getLoanDate();
//			loan[5] = String.valueOf(loanlist.get(i).getDeadline());
//			loan[6] = String.valueOf(loanlist.get(i).isExtension());
//			export.add(loan);
//		}
//		csvwriter.writeCSV(export, "loan.csv");
//	}
	
}
