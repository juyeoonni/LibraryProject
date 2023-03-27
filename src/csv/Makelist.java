package csv;

import java.lang.reflect.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import book.*;
import loan.*;
import member.*;

public class Makelist {

	CSVReader cr = new CSVReader();

	
	public List<MemberValue> memberlist() {
		List<List<String>> list = cr.readCSV("member.csv");
		List<MemberValue> memberlist = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			List<String> l = list.get(i);
			MemberValue mem = new MemberValue();
			mem.setMemberID((l.get(0)));
			mem.setName(l.get(1));
			mem.setAge(Integer.parseInt(l.get(2)));
			mem.setAddress(l.get(3));
			mem.setPhoneNumber(l.get(4));
			mem.setDateOfBirth(l.get(5));
			mem.setDateOfMembership(l.get(6));
			memberlist.add(mem);
		}
		return memberlist;
	}

	
	public List<Book> booklist() {
		List<List<String>> list = cr.readCSV("book.csv");
		List<Book> booklist = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			List<String> l = list.get(i);
			Book b = new Book();
			b.setIsbn((l.get(0)));
			b.setTitle(l.get(1));
			b.setAuthor(l.get(2));
			b.setPublisher((l.get(3)));
			b.setPublicationDate((l.get(4)));
			b.setAvailable(Boolean.valueOf((l.get(5))));
			booklist.add(b);
			
		}
		return booklist;
	}
	
//	public List<Loan> loanlist() {
//		List<List<String>> list = cr.readCSV("loan.csv");
//		List<Loan> loanlist = new ArrayList<>();
//		for (int i = 1; i < list.size(); i++) {
//			List<String> l = list.get(i);
//			Loan loan = new Loan();
//			loan.setId(Integer.parseInt(l.get(0)));
//			loan.setMemberName(l.get(1));
//			loan.setBookTitle(l.get(2));
//			loan.setRenewStatus(Boolean.valueOf(l.get(3)));
//			loan.setLoanDate(l.get(4));
//			loan.setDeadline(Integer.parseInt(l.get(5)));
//			loan.setExtension(Boolean.valueOf(l.get(6)));	
//			loanlist.add(loan);
//		}
//		return loanlist;
//	}

}
