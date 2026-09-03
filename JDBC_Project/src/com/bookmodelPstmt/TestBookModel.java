package com.bookmodelPstmt;

public class TestBookModel {

	public static void main(String[] args) throws Exception {

//		testcreateTable();
//		testnextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();

	}

	public static void testcreateTable() throws Exception {

		BookModel b = new BookModel();

		b.createTable();

	}

	public static void testnextPk() throws Exception {

		BookModel b = new BookModel();
		b.nextPk();

	}

	public static void testAdd() throws Exception {

		BookModel model = new BookModel();
		BookModelBean bean = new BookModelBean();

		bean.setBookId(104);
		bean.setTitle("Database Systems");
		bean.setAuthor("Abraham Silberschatz");
		bean.setPrice(1050.00);
		bean.setPublicationYear(2002);

		model.add(bean);
	}

	public static void testUpdate() throws Exception {

		BookModel model = new BookModel();
		BookModelBean bean = new BookModelBean();

		bean.setTitle("Database Systems");
		bean.setAuthor("Abraham Silberschatz");
		bean.setPrice(1050.00);
		bean.setPublicationYear(2005);
		bean.setBookId(104);

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		BookModel model = new BookModel();
		BookModelBean bean = new BookModelBean();

		model.delete(104);
	}
	
	public static void testSearch() throws Exception {
		BookModel model = new BookModel();
		BookModelBean bean = new BookModelBean();
		
		model.Search(bean);
	}

}
