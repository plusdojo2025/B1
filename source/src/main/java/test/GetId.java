package test;

import dao.CategoriesDao;
import dao.ManualsDao;
import dao.TasksDao;
import dto.Manual;

public class GetId {

	public static void main(String[] args) {
		
		//カテゴリID取得
		String category = "料理";
		CategoriesDao cateDao = new CategoriesDao();
		int categoryId = cateDao.getId(category);
		System.out.println("カテゴリID:"+categoryId);
		
		
		//タスクID取得
		String task = "じゃがバター";
		TasksDao taskDao = new TasksDao();
		//タスクIDを取得
		int taskId = taskDao.getId(task);	
		System.out.println("タスクID:"+taskId);
		
		//マニュアル登録
		String manualBody = "テスト";
		ManualsDao manuDao = new ManualsDao();
		Manual manuDto = new Manual(categoryId,taskId,manualBody);
		boolean result = manuDao.insert(manuDto);
		System.out.println("結果:"+result);
		
	}

}
