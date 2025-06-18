package test;

import dao.UsersDao;
import dto.Users;

public class LoginTest {
	public static void main(String[] args) {
		testIsLoginOK1(); // ユーザーが見つかる場合のテスト
	}
	
	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		String email = "tamura@example.com";
		String pw = "Boss4649";
		UsersDao uDao = new UsersDao();
		if (uDao.isLoginOK(new Users(email,pw))) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}
}
