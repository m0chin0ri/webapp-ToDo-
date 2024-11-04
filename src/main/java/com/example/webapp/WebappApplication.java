package com.example.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//アプリケーションのメインクラスであることを示す

//@RequiredArgsConstructor
//finalフィールドを持つ全てのコンストラクタを自動生成

public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	//☆以下の処理が「ToDoController」に委託されている
	/*	public static void main(String[] args) {
			SpringApplication.run(WebappApplication.class, args)
					.getBean(WebappApplication.class).exe();
		}
		
		// DI
		private final ToDoService service;
		
		public void exe() {
			// ★全件検索
			System.out.println("=== 全件検索 ===");
			for (ToDo row : service.findAllToDo()) {
				System.out.println(row);
			}
		
			// ★1件検索
			System.out.println("=== 1件検索 ===");
			System.out.println(service.findByIdToDo(1));
		
			// ★登録
			// 登録データ作成
			ToDo todo = new ToDo();
			todo.setTodo("リポジトリのテスト");
			todo.setDetail("DBへの登録処理");
		
			service.insertToDo(todo);
		
			System.out.println("=== 登録確認 ===");
			System.out.println(service.findByIdToDo(4));
		
			// ★更新
			ToDo target = service.findByIdToDo(4);
			target.setTodo("リポジトリのテスト: 更新");
			target.setDetail("DBへの更新処理");
		
			service.updateToDo(target);
		
			System.out.println("=== 更新確認 ===");
			System.out.println(service.findByIdToDo(4));
		
			// ★削除
			service.deleteToDo(4);
		
			System.out.println("=== 削除確認 ===");
			for (ToDo row : service.findAllToDo()) {
				System.out.println(row);
			}
		}*/
}