package test;

import dao.UsersDao;
import dto.Users;

public class UsersTest {

	public static void main(String[] args) {
		//ユーザー登録テスト
		//insert();
		
		//ユーザー更新テスト
		//update();

		//ユーザー情報取得テスト
		//userInfo();
		
		userInfoById();
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
	
	//ユーザー情報取得
	public static void userInfo() {
		String email="dojouser1@plusdojo.jp";
		UsersDao uDao = new UsersDao();
		Users user = uDao.userInfo(email);
		System.out.println(user);
	}
	
	public static void userInfoById() {
		int id = 1;
		UsersDao uDao = new UsersDao();
		Users user = uDao.userInfoById(id);
		System.out.println(user);
	}
	
	//ユーザー更新
	public static void update() {
		int id = 1;
		String name = "dojouser1";
		String email = "dojouser1@plusdojo.jp";
		String pw = "#SEplus2025SEplus";
		String role = "社員";
		UsersDao uDao = new UsersDao();
		if (uDao.update(new Users(id,name,email,pw,role))) {
			System.out.println("ユーザー更新：成功しました");
		} else {
			System.out.println("ユーザー更新：失敗しました");
		}
	}

}
