package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.ReviewsDao;
import dto.Reviews;

public class Reviewstest {
	public static void main(String[] args) {
		testgetId(); // ユーザーが見つかる場合のテスト
	}
	
	// レビューのついたマニュアルが見つかる場合のテスト
	public static void testgetId() {
		
		ReviewsDao uDao = new ReviewsDao();
		List<Reviews>test = uDao.getId();
			
		for (Reviews item : test) {
		    System.out.println(item);
		}
		
		List<Integer> manualIdList = new ArrayList<>();

		for (Reviews m : test) {
		    manualIdList.add(m.getManual_id());
		}
		System.out.println(manualIdList);
		int max = Collections.max(manualIdList);
		List<Integer> y = new ArrayList<>();
		for (int i = 1; i <= max; i++) {
			int x = uDao.review_avg_half(i);
			System.out.println(x);
			if(x <= 3) {
				y.add(x);
			}
			System.out.println(y);
		}
		
}
}
