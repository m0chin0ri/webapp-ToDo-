SELECT id, todo, detail, created_at, updated_at
	FROM public.todos;

-- メソッド: selectAllで使用
SELECT id, todo, detail, created_at, updated_at FROM todos;

-- メソッド: selectByIdで使用
SELECT id, todo, detail, created_at, updated_at FROM todos WHERE id = 1;

-- メソッド: insertで使用
INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('チケット購入', '東京ドーム (新日本)', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- メソッド: updateで使用
UPDATE todos SET todo='ショッピング', detail='デパートで散財する',
                                            updated_at=CURRENT_TIMESTAMP WHERE id = 1;

-- メソッド: deleteで使用
DELETE FROM todos WHERE id = 10;