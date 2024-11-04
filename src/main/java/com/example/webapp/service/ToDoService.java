package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.ToDo;

/**
 * ToDo: サービス
 */
public interface ToDoService {
	/**
	 * 全ての「こと」を検索します。
	 */
	List<ToDo> findAllToDo();

	/**
	 * 指定されたIDの「こと」を検索します。
	 */
	ToDo findByIdToDo(Integer id);

	/**
	 * 「こと」を新規登録します。
	 */
	void insertToDo(ToDo toDo);

	/**
	 * 「こと」を更新します。
	 */
	void updateToDo(ToDo toDo);

	/**
	 * 指定されたIDの「こと」を削除します。
	 */
	void deleteToDo(Integer id);
}