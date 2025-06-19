package test;

import java.sql.Timestamp;

import dao.SchedulesDao;

public class TestSchedulesDao {
    public static void main(String[] args) {
        // テスト用のデータ
        int testUserId = 2;        // 実際に users テーブルに存在する ID を使ってください
        int testCategoryId = 1;    // 実際に categories テーブルに存在する ID を使ってください
        Timestamp testDate = Timestamp.valueOf("2025-06-19 00:00:00");

        // DAO 呼び出し
        SchedulesDao dao = new SchedulesDao();
        boolean result = dao.insert(testUserId, testCategoryId, testDate);

        // 結果出力
        if (result) {
            System.out.println("✅ 登録成功");
        } else {
            System.out.println("❌ 登録失敗");
        }
    }
}