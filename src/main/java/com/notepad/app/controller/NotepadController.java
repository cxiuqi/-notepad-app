package com.notepad.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notepad.app.model.Note;
import com.notepad.app.service.NotepadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notepad")
@RequiredArgsConstructor
public class NotepadController {
	
	private final NotepadService service;
	
	@PostMapping
	private void createNote(@RequestBody Note note) {
		service.createNote(note);
	}
	
	@DeleteMapping("/{id}")
	private void deleteNote(@PathVariable long id) {
		service.deleteNote(id); 
	}
	
	@GetMapping("/all")	
	private List<Note> getAllNotes() {
		return service.getAllNotes();
	}
	
	@GetMapping("/{id}")	
	private Note getNoteById(@PathVariable long id) {
		return service.getNote(id);
	}
	
	@PostMapping("/{id}")	
	private void editNoteById(@PathVariable long id, @RequestBody Note note) throws Exception {
		if(id == note.getId()) {
			service.editNote(id, note);
		}
		else {
			throw new Exception("id does not match given body");
		}
	}
}
