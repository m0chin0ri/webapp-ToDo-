-- 「todos」テーブルが存在したら削除する
DROP TABLE IF EXISTS todos;

-- 「todos」テーブルの作成
CREATE TABLE todos (
    -- id (することID): 主キー
    --serial：自動で連番が割り当てられる整数型のデータ型
    --PRIMARY KEYは：この列がテーブルの一意の識別子である意味。左記によりidの値は必ずユニークで、NULL値はない
    id serial PRIMARY KEY,
    
    -- todo (すること): NULL不許可
    --varchar(255)：255文字までの可変長の文字列を格納するデータ型。
	--NOT NULL制約：todoには必ず値が入る必要がある
    todo varchar(255) NOT NULL,
    
    -- detail (説明)
    --text型の定義、NOT NULLの記載がない場合はdetail列はnullでも問題ない
    detail text,
    
    -- created_at (作成日)
    --タイムゾーンを含まない日付と時刻の情報を格納
    created_at timestamp without time zone,
    
    -- updated_at (更新日)
    updated_at timestamp without time zone
    
); 