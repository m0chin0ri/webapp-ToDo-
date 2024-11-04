package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.ToDo;
import com.example.webapp.form.ToDoForm;
import com.example.webapp.helper.ToDoHelper;
import com.example.webapp.service.ToDoService;

import lombok.RequiredArgsConstructor;

/**
 * ToDo: コントローラ
 */
@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

	private final ToDoService toDoService;

	/**
	 * 「こと」の一覧を表示します。
	 */
	@GetMapping
	public String list(Model model) {
		model.addAttribute("todos", toDoService.findAllToDo());
		return "todo/list";
	}

	/**
	 * 指定されたIDの「こと」の詳細を表示します。
	 */
	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		// 「こと」とIDに対応する「こと」情報を取得
		ToDo ToDo = toDoService.findByIdToDo(id);

		if (ToDo != null) {
			// 対象データがある場合はモデルに格納
			model.addAttribute("todo", ToDo);
			return "todo/detail";
		} else {
			// 対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			// リダイレクト
			return "redirect:/todos";
		}
	}

	// === 登録、更新処理追加 ===

	/**
	 * 新規登録画面を表示します。
	 */
	@GetMapping("/form")
	public String newToDo(@ModelAttribute ToDoForm form) {
		// 新規登録画面の設定
		form.setIsNew(true);
		return "todo/form";
	}

	/**
	 * 新規登録を実行します。
	 */
	@PostMapping("/save")
	public String create(ToDoForm form, RedirectAttributes attributes) {
		// エンティティへの変換
		ToDo ToDo = ToDoHelper.convertToDo(form);
		// 登録実行
		toDoService.insertToDo(ToDo);
		// フラッシュメッセージ
		attributes.addFlashAttribute("message", "新しいToDoが作成されました");
		// PRGパターン
		return "redirect:/todos";
	}

	/**
	 * 指定されたIDの修正画面を表示します。
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		// IDに対応する「すること」を取得
		ToDo target = toDoService.findByIdToDo(id);

		if (target != null) {
			// 対象データがある場合はフォームへの変換
			ToDoForm form = ToDoHelper.convertToDoForm(target);
			// モデルに格納
			model.addAttribute("toDoForm", form);
			return "todo/form";
		} else {
			// 対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			// 一覧画面へリダイレクト
			return "redirect:/todos";
		}
	}

	/**
	 * 「すること」の情報を更新します。
	 */
	@PostMapping("/update")
	public String update(ToDoForm form, RedirectAttributes attributes) {
		// エンティティへの変換
		ToDo ToDo = ToDoHelper.convertToDo(form);
		// 更新処理
		toDoService.updateToDo(ToDo);
		// フラッシュメッセージ
		attributes.addFlashAttribute("message", "ToDoが更新されました");
		// PRGパターン
		return "redirect:/todos";
	}

	/**
	 * 指定されたIDの「すること」を削除します。
	 */
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
		// 削除処理
		toDoService.deleteToDo(id);

		// フラッシュメッセージ
		attributes.addFlashAttribute("message", "ToDoが削除されました");

		// PRGパターン
		return "redirect:/todos";
	}

}