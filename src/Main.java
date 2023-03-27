
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

		System.out.println("=== ������ ���� ���� ���α׷��� �����մϴ�! ������ ���͵帱���? ===");
		System.out.println("1. ȸ������\t2. ��������\t3. �������\t4. ����");

		Scanner scn = new Scanner(System.in);

		int menuNum = scn.nextInt();

		switch (menuNum) {
		case 1:

			System.out.println("ȸ�� ���� ȭ���Դϴ�");
			System.out.println("1. ȸ���߰�\t2. ȸ������\t3. ȸ����ȸ\t4. ȸ����������");
			int memberMangement = scn.nextInt();

			switch (memberMangement) {
			case 1:
				System.out.println("=================================================");
				System.out.println("                   *ȸ��  �߰�*");
				System.out.println("=================================================");

				System.out.print("ID�� �Է��ϼ���: ");
				String memberID = scn.next();

				System.out.print("�̸��� �Է��ϼ���: ");
				String name = scn.next();

				System.out.print("���̸� �Է��ϼ���: ");
				int age = scn.nextInt();

				System.out.print("�ּҸ� �Է��ϼ���: ");
				String address = scn.next();

				System.out.print("�޴��� ��ȣ�� �Է��ϼ���: ");
				String phoneNumber = scn.nextLine();

				System.out.print("������ �Է��ϼ���: ");
				String dateOfBirth = scn.nextLine();

				System.out.print("�������� �Է��ϼ���: ");
				String dateOfMembership = scn.next();

				MemberValue mv = new MemberValue(memberID, name, age, address, phoneNumber, dateOfBirth,
						dateOfMembership);
				memberlist.add(mv);
				System.out.println("ȸ���� �߰��߽��ϴ�!");
				break;

			case 2:
				System.out.println("=================================================");
				System.out.println("                   *ȸ��  ����*");
				System.out.println("=================================================");

				System.out.print("������ ȸ�� ID�� �Է��ϼ���: ");
				String delID = scn.next();
				for (int i = 0; i < memberlist.size(); i++) {
					if (delID.equals(memberlist.get(i).getMemberID())) {
						memberlist.remove(memberlist.get(i));
						System.out.println("ȸ���� �����߽��ϴ�!");
					} else {
						System.out.println("������ ȸ���� �������� �ʽ��ϴ�!");
					}
				}
				break;
			case 3:
				System.out.println("=================================================");
				System.out.println("                   *ȸ��  ��ȸ*");
				System.out.println("=================================================");
				System.out.println("ȸ�� ����� ������: " + memberlist.size()); 
				for (MemberValue m : memberlist) {
					System.out.println("ID: " + m.getMemberID());
					System.out.println(m);
				}
				System.out.println("ȸ�� ����� ��ȸ�߽��ϴ�");
				break;
			case 4:
				System.out.println("=================================================");
				System.out.println("                   *ȸ��  ���� ����*");
				System.out.println("=================================================");
				String updateID = scn.next();
				for (int i = 0; i < memberlist.size(); i++) {
					if (updateID.equals(memberlist.get(i).getMemberID())) {
						MemberValue mem = new MemberValue();

						System.out.print("������ �̸��� �Է��ϼ���: ");
						String updateName = scn.next();
						mem.setName(updateName);

						System.out.print("������ ���̸� �Է��ϼ���: ");
						int updateAge = scn.nextInt();
						mem.setAge(updateAge);

						System.out.print("������ �ּҸ� �Է��ϼ���: ");
						String updateAddress = scn.next();
						mem.setAddress(updateAddress);

						System.out.print("������ �޴��� ��ȣ�� �Է��ϼ���: ");
						String updatePhoneNumber = scn.next();
						mem.setPhoneNumber(updatePhoneNumber);

						System.out.print("������ ������ �Է��ϼ���: ");
						String updateDateOfBirth = scn.next();
						mem.setDateOfBirth(updateDateOfBirth);

						System.out.print("������ �������� �Է��ϼ���: ");
						String updateDateOfMembership = scn.next();
						mem.setDateOfMembership(updateDateOfMembership);

						memberlist.set(memberlist.indexOf(memberlist.get(i)), mem);

					}
					break;
				}

			}
		case 2:
			System.out.println("���� ���� ȭ���Դϴ�");
			System.out.println("1. �����߰�\t2. ��������\t3. �����˻�\t4. ������������");
			int bookMangement = scn.nextInt();

			switch (bookMangement) {
			case 1:
				System.out.println("=================================================");
				System.out.println("                   *����  �߰�*");
				System.out.println("=================================================");
				Scanner scanner1 = new Scanner(System.in);

				System.out.print("������ȣ�� �Է��ϼ���: ");
				String isbn = scanner1.next();

				System.out.print("�������� �Է��ϼ���: ");
				String title = scanner1.next();

				System.out.print("�۰��� �̸��� �Է��ϼ���: ");
				String author = scanner1.next();

				System.out.print("���ǻ縦 �Է��ϼ���: ");
				String publisher = scanner1.next();

				System.out.print("�������� �Է��ϼ���: ");
				String publicationDate = scanner1.next();

				System.out.print("�뿩 ���� ���θ� �Է��ϼ���: ");
				boolean isAvailable = scanner1.hasNext();

				Book book = new Book(isbn, title, author, publisher, publicationDate, isAvailable);
				booklist.add(book);
				System.out.println("�� å�� �߰��߽��ϴ�!");
				break;

			case 2:
				System.out.println("=================================================");
				System.out.println("                   *����  ����*");
				System.out.println("=================================================");

				System.out.println("������ ���� isbn�� �Է��ϼ���: ");
				Scanner sc1 = new Scanner(System.in);
				String delBookIsbn = sc1.next();
				for (int j = 0; j < booklist.size(); j++) {
					if (delBookIsbn.contentEquals(booklist.get(j).getIsbn())) {
						booklist.remove(booklist.get(j));
						System.out.println("������ �����߽��ϴ�!");
					} else {
						System.out.println("������ ������ �������� �ʽ��ϴ�!");
					}
				}
				break;

			case 3:
				System.out.println("=================================================");
				System.out.println("                   *����  ��ȸ*");
				System.out.println("=================================================");

				for (Book bk : booklist) {
					System.out.println(bk);
					System.out.println("���� ����� ��ȸ�մϴ�");
				}
				break;
			case 4:
				System.out.println("=================================================");
				System.out.println("                   *����  ���� ����*");
				System.out.println("=================================================");
				String updateIsbn = scn.next();
				for (int i = 0; i < booklist.size(); i++) {
					if (updateIsbn.equals(booklist.get(i).getIsbn())) {
						Book udBook = new Book();

						System.out.print("������ å������ �Է��ϼ���: ");
						String updateTitle = scn.next();
						udBook.setTitle(updateTitle);
						System.out.print("������ �۰��� �̸��� �Է��ϼ���: ");
						String updateAuthor = scn.next();
						udBook.setAuthor(updateAuthor);
						System.out.print("������ ���ǻ��� �̸��� �Է��ϼ���: ");
						String updatePublisher = scn.next();
						udBook.setPublisher(updatePublisher);
						System.out.print("������ �������� �Է��ϼ���: ");
						String updatePublicationDate = scn.next();
						udBook.setPublicationDate(updatePublicationDate);
						System.out.print("������ �뿩���θ� �Է��ϼ���: ");
						boolean updateisAvailable = Boolean.parseBoolean(scn.next());
						udBook.setAvailable(updateisAvailable);

						booklist.set(booklist.indexOf(booklist.get(i)), udBook);
						break;
					}

				}
				break;
			}
		case 3:
			System.out.println("���� ���� ȭ���Դϴ�");
			break;

		case 4:
			System.out.println("�ȳ��� ������ :)");
			break;
		}

		Exportlist el = new Exportlist();
		el.exportMember(memberlist);
		el.exportBook(booklist);
	}
}
// el.exportLoan(loanlist);
