package test;

import dao.UsersDao;
import dto.Users;

public class UsersTest {

	public static void main(String[] args) {
		//ユーザー登録テスト
		insert();

	}
	
	//ユーザー登録
	public static void insert() {
		int id = 0;
		String name = "dojouser1";
		String email = "dojouser1@plusdojo.jp";
		String pw = "#SEplus2025SEplus";
		String role = "社員";
		UsersDao uDao = new UsersDao();
		if (uDao.insert(new Users(id,name,email,pw,role))) {
			System.out.println("ユーザー登録：成功しました");
		} else {
			System.out.println("ユーザー登録：失敗しました");
		}
	}

}
