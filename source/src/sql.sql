/*テーブルの名前は大文字 or 小文字で統一なので テーブル名は【小文字】で統一します。*/ 

 /*1. users テーブル*/ 

/*①データベースを作成して使います。*/ 

 CREATE DATABASE b1;  

USE b1; 

 /*②テーブルを作成します。*/ 

 CREATE TABLE users( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/ 

 name VARCHAR(50) NOT NULL, /*名前*/  

email VARCHAR(100) NOT NULL, /*ログイン ID(メール)*/  

pw VARCHAR(20) NOT NULL, /*パスワード*/  

role VARCHAR(10) NOT NULL, /*役割*/ 

 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*③テーブルに 5 件のデータを登録します。(デモデータ)*/ 

 INSERT INTO users (name,email,pw,role) values ('佐藤 悠真 ','dojouser1@plusdojo.jp','#SEplus2025SEplus','社員'); 

 INSERT INTO users (name,email,pw,role) values ('月島 陽','dojouser2@plusdojo.jp','#SEplus2025SEplus','社員');  

INSERT INTO users (name,email,pw,role) values ('高橋 美咲 ','dojouser3@plusdojo.jp','#SEplus2025SEplus','アルバイト');  

INSERT INTO users (name,email,pw,role) values ('中村 蓮 ','dojouser4@plusdojo.jp','#SEplus2025SEplus','アルバイト');  

INSERT INTO users (name,email,pw,role) values ('松本 葵 ','dojouser5@plusdojo.jp','#SEplus2025SEplus','アルバイト'); 

 /*④データが登録されたことを確認します。*/ 

 SELECT * FROM users; 

 /*ここからはテーブル作成のみ・データベースを選択します。*/ 

 USE b1; 

 /*1. categories テーブル*/  

CREATE TABLE categories ( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

category VARCHAR(50) NOT NULL, /*カテゴリ*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*デモデータ 3 件を登録します。*/  

INSERT INTO categories (category) VALUES ('料理'), ('清掃'), ('接客'); 

 /*2. tasks テーブル*/  

CREATE TABLE tasks ( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

task VARCHAR(50) NOT NULL, /*タスク*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*デモデータ 10 件を登録します。*/  

INSERT INTO tasks (task)VALUES ('食器洗い'),('ポテトサラダ'),('キッチン清掃'),('オーダー'),('商品提供'),('バッシング'),('レジ'),('定期確認'),('ホール清掃'),('鯛の炊き込みご飯 ');  

/*3. places テーブル*/ 

 CREATE TABLE places (  

id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/ 

place VARCHAR(50) NOT NULL, /*場所*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/ 

 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/ 

 /*デモデータを追加します*/  

INSERT INTO places (place) VALUES ('キッチン'), ('ホール'), ('トイレ'),('レジ'); 

 /*4. tools テーブル*/  

CREATE TABLE tools( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

tool VARCHAR(20) NOT NULL, /*道具*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*デモデータを追加します*/  

INSERT INTO tools (tool) VALUES ('なし'),('包丁'),('ピーラー'),('フォーク'),('スプーン'),('フライパン'),('鍋'),('スポンジ'),('たわし'),('じゃがいも'),('塩'),('マヨネーズ'),('食器用洗剤'),('トイレクリーナー'),('アルコール'),('メモ帳'),('筆記用具'),('電話'); 

 /*5. processes テーブル*/  

CREATE TABLE processes( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/ 

 task_id INT NOT NULL, /*業務(外部キー)*/ 

 FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,  

process VARCHAR(200), /*手順*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*6. points テーブル*/ 

 CREATE TABLE points ( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/ 

 user_id INT NOT NULL, /*名前(外部キー)*/ 

 FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,  

point INT DEFAULT 0 , /*ポイント(デフォルト値 0)*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/ 

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/* テーブルに 3 件のデータを登録します。（デモデータ）*/  

INSERT INTO points (user_id, point) VALUES (1, 5),(2, 3),(3, 8); 

 /*7. schedules テーブル*/  

CREATE TABLE schedules ( 

id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

user_id INT NOT NULL, /*名前(外部キー)*/  

FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE, date TIMESTAMP NOT NULL, /*日付*/  

category_id INT , /*カテゴリ(外部キー)*/  

FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*8. manuals テーブル*/ 

 CREATE TABLE manuals(  

id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

category_id INT NOT NULL, /*カテゴリ(外部キー)*/  

FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE, 

 task_id INT NOT NULL, /*業務(外部キー)*/  

FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE, 

 body VARCHAR(1000), /*マニュアル本体*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*デモデータ 3 件を登録します*/  

INSERT INTO manuals (category_id, task_id, body) VALUES (1, 2, '1. じゃがいもをよく洗い、皮をむく。\n2. やわらかくなるまで茹でる。\n3. フォ ークで潰して塩・マヨネーズで味付け。\n4. 盛り付けて提供する。'), (1, 1, '1. 残飯を捨てて軽く水で流す。\n2. 洗剤を使ってしっかり洗う。\n3. 水気を切っ てラックに並べる。\n4. 必要があれば消毒も行う。'), (3, 4, '1. 笑顔で「いらっしゃいませ」と挨拶。\n2. 注文を復唱して確認。\n3. ミスがな いようメモに入力。\n4. 厨房に伝える。');  

/*9. reviews テーブル*/  

CREATE TABLE reviews ( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

manual_id INT NOT NULL, /*マニュアル(外部キー)*/  

FOREIGN KEY (manual_id) REFERENCES manuals (id) ON DELETE CASCADE, 

 user_id INT NOT NULL, /*評価した人(外部キー)*/  

FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,  

review INT DEFAULT 0, /*評価(デフォルト値 0)*/  

comment VARCHAR(200), /*コメント*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/ 

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/* デモデータを 7 件追加します */  

INSERT INTO reviews (manual_id, user_id, review, comment)VALUES (1, 1, 5, 'とても分かりやすかったです'), (2, 2, 4, 'もう少し詳しい説明がほしいです'), (1, 3, 3, '普通でしたが、役には立ちました'), (3, 1, 2, '使い方が少し分かりにくかった'), (2, 4, 5, '素晴らしい内容で助かりました'), (2, 1, 3, '分かりやすかったです'), (1, 2, 3, '詳しい説明がほしいです');  

/*10. prompts テーブル*/  

CREATE TABLE prompts (  

id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

category_id INT NOT NULL, /*カテゴリ(外部キー)*/ 

FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE,  

task_id INT NOT NULL, /*業務(外部キー)*/  

FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,  

place_id INT NOT NULL, /*場所(外部キー)*/  

FOREIGN KEY (place_id) REFERENCES places (id) ON DELETE CASCADE,  

tool_id INT NOT NULL, /*道具(外部キー)*/  

FOREIGN KEY (tool_id) REFERENCES tools (id) ON DELETE CASCADE,  

process_id INT NOT NULL, /*手順(外部キー)*/  

FOREIGN KEY (process_id) REFERENCES processes (id) ON DELETE CASCADE,  

time TIME DEFAULT '00:00:00', /*目標時間*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/ 

/*11. updates テーブル*/  

CREATE TABLE updates (  

id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

manual_id INT NOT NULL, /*マニュアル(外部キー)*/  

FOREIGN KEY (manual_id) REFERENCES manuals (id) ON DELETE CASCADE, 

 user_id INT NOT NULL, /*コメントした人(外部キー)*/  

FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,  

has_update BOOLEAN DEFAULT false, /*更新済みか*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  

/*12. checks テーブル*/  

CREATE TABLE checks ( 

 id INT AUTO_INCREMENT PRIMARY KEY, /*id(自動採番)*/  

manual_id INT NOT NULL, /*マニュアル(外部キー)*/  

FOREIGN KEY (manual_id) REFERENCES manuals (id) ON DELETE CASCADE, user_id INT NOT NULL, /*コメントした人(外部キー)*/  

FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,  

has_check BOOLEAN DEFAULT false, /*確認済みか*/  

created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*データを追加した日時*/  

updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP); /*データを更新した日時*/  