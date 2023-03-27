
import java.time.*;
import java.util.*;

import book.*;
import csv.*;
import library.*;
import member.*;

public class Main {

	public static void main(String[] args) {

		Makelist ml = new Makelist();
		List<MemberValue> memberlist = ml.memberlist();
		List<Book> booklist = ml.booklist();

		System.out.println("=== 도서관 대출 관리 프로그램을 시작합니다! 무엇을 도와드릴까요? ===");
		System.out.println("1. 회원관리\t2. 도서관리\t3. 대출관리\t4. 종료");

		Scanner scn = new Scanner(System.in);

		int menuNum = scn.nextInt();

		switch (menuNum) {
		case 1:

			System.out.println("회원 관리 화면입니다");
			System.out.println("1. 회원추가\t2. 회원삭제\t3. 회원조회\t4. 회원정보수정");
			int memberMangement = scn.nextInt();

			switch (memberMangement) {
			case 1:
				System.out.println("=================================================");
				System.out.println("                   *회원  추가*");
				System.out.println("=================================================");

				System.out.print("ID를 입력하세요: ");
				String memberID = scn.next();

				System.out.print("이름을 입력하세요: ");
				String name = scn.next();

				System.out.print("나이를 입력하세요: ");
				int age = scn.nextInt();

				System.out.print("주소를 입력하세요: ");
				String address = scn.next();

				System.out.print("휴대폰 번호를 입력하세요: ");
				String phoneNumber = scn.nextLine();

				System.out.print("생일을 입력하세요: ");
				String dateOfBirth = scn.nextLine();

				System.out.print("가입일을 입력하세요: ");
				String dateOfMembership = scn.next();

				MemberValue mv = new MemberValue(memberID, name, age, address, phoneNumber, dateOfBirth,
						dateOfMembership);
				memberlist.add(mv);
				System.out.println("회원을 추가했습니다!");
				break;

			case 2:
				System.out.println("=================================================");
				System.out.println("                   *회원  삭제*");
				System.out.println("=================================================");

				System.out.print("삭제할 회원 ID를 입력하세요: ");
				String delID = scn.next();
				for (int i = 0; i < memberlist.size(); i++) {
					if (delID.equals(memberlist.get(i).getMemberID())) {
						memberlist.remove(memberlist.get(i));
						System.out.println("회원을 삭제했습니다!");
					} else {
						System.out.println("삭제할 회원이 존재하지 않습니다!");
					}
				}
				break;
			case 3:
				System.out.println("=================================================");
				System.out.println("                   *회원  조회*");
				System.out.println("=================================================");
				System.out.println("회원 목록의 사이즈: " + memberlist.size()); 
				for (MemberValue m : memberlist) {
					System.out.println("ID: " + m.getMemberID());
					System.out.println(m);
				}
				System.out.println("회원 목록을 조회했습니다");
				break;
			case 4:
				System.out.println("=================================================");
				System.out.println("                   *회원  정보 수정*");
				System.out.println("=================================================");
				String updateID = scn.next();
				for (int i = 0; i < memberlist.size(); i++) {
					if (updateID.equals(memberlist.get(i).getMemberID())) {
						MemberValue mem = new MemberValue();

						System.out.print("수정할 이름을 입력하세요: ");
						String updateName = scn.next();
						mem.setName(updateName);

						System.out.print("수정할 나이를 입력하세요: ");
						int updateAge = scn.nextInt();
						mem.setAge(updateAge);

						System.out.print("수정할 주소를 입력하세요: ");
						String updateAddress = scn.next();
						mem.setAddress(updateAddress);

						System.out.print("수정할 휴대폰 번호를 입력하세요: ");
						String updatePhoneNumber = scn.next();
						mem.setPhoneNumber(updatePhoneNumber);

						System.out.print("수정할 생일을 입력하세요: ");
						String updateDateOfBirth = scn.next();
						mem.setDateOfBirth(updateDateOfBirth);

						System.out.print("수정할 가입일을 입력하세요: ");
						String updateDateOfMembership = scn.next();
						mem.setDateOfMembership(updateDateOfMembership);

						memberlist.set(memberlist.indexOf(memberlist.get(i)), mem);

					}
					break;
				}

			}
		case 2:
			System.out.println("도서 관리 화면입니다");
			System.out.println("1. 도서추가\t2. 도서삭제\t3. 도서검색\t4. 도서정보수정");
			int bookMangement = scn.nextInt();

			switch (bookMangement) {
			case 1:
				System.out.println("=================================================");
				System.out.println("                   *도서  추가*");
				System.out.println("=================================================");
				Scanner scanner1 = new Scanner(System.in);

				System.out.print("도서번호를 입력하세요: ");
				String isbn = scanner1.next();

				System.out.print("도서명을 입력하세요: ");
				String title = scanner1.next();

				System.out.print("작가의 이름을 입력하세요: ");
				String author = scanner1.next();

				System.out.print("출판사를 입력하세요: ");
				String publisher = scanner1.next();

				System.out.print("출판일을 입력하세요: ");
				String publicationDate = scanner1.next();

				System.out.print("대여 가능 여부를 입력하세요: ");
				boolean isAvailable = scanner1.hasNext();

				Book book = new Book(isbn, title, author, publisher, publicationDate, isAvailable);
				booklist.add(book);
				System.out.println("새 책을 추가했습니다!");
				break;

			case 2:
				System.out.println("=================================================");
				System.out.println("                   *도서  삭제*");
				System.out.println("=================================================");

				System.out.println("삭제할 도서 isbn을 입력하세요: ");
				Scanner sc1 = new Scanner(System.in);
				String delBookIsbn = sc1.next();
				for (int j = 0; j < booklist.size(); j++) {
					if (delBookIsbn.contentEquals(booklist.get(j).getIsbn())) {
						booklist.remove(booklist.get(j));
						System.out.println("도서를 삭제했습니다!");
					} else {
						System.out.println("삭제할 도서가 존재하지 않습니다!");
					}
				}
				break;

			case 3:
				System.out.println("=================================================");
				System.out.println("                   *도서  조회*");
				System.out.println("=================================================");

				for (Book bk : booklist) {
					System.out.println(bk);
					System.out.println("도서 목록을 조회합니다");
				}
				break;
			case 4:
				System.out.println("=================================================");
				System.out.println("                   *도서  정보 수정*");
				System.out.println("=================================================");
				String updateIsbn = scn.next();
				for (int i = 0; i < booklist.size(); i++) {
					if (updateIsbn.equals(booklist.get(i).getIsbn())) {
						Book udBook = new Book();

						System.out.print("수정할 책제목을 입력하세요: ");
						String updateTitle = scn.next();
						udBook.setTitle(updateTitle);
						System.out.print("수정할 작가의 이름을 입력하세요: ");
						String updateAuthor = scn.next();
						udBook.setAuthor(updateAuthor);
						System.out.print("수정할 출판사의 이름을 입력하세요: ");
						String updatePublisher = scn.next();
						udBook.setPublisher(updatePublisher);
						System.out.print("수정할 출판일을 입력하세요: ");
						String updatePublicationDate = scn.next();
						udBook.setPublicationDate(updatePublicationDate);
						System.out.print("수정할 대여여부를 입력하세요: ");
						boolean updateisAvailable = Boolean.parseBoolean(scn.next());
						udBook.setAvailable(updateisAvailable);

						booklist.set(booklist.indexOf(booklist.get(i)), udBook);
						break;
					}

				}
				break;
			}
		case 3:
			System.out.println("대출 관리 화면입니다");
			break;

		case 4:
			System.out.println("안녕히 가세요 :)");
			break;
		}

		Exportlist el = new Exportlist();
		el.exportMember(memberlist);
		el.exportBook(booklist);
	}
}
// el.exportLoan(loanlist);
