--CURRENT_TIMESTAMP ：現在の日時を取得。新しくデータを挿入するタイミングの日時が自動的に設定
--以下、schema.sqlでルール付けした内容に基づいて作成している。

-- 1件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('買い物', 'スーパーで食材を購入する', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 2件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('図書館に行く', '本を借りる', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 3件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('ジムに行く', '運動する', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);