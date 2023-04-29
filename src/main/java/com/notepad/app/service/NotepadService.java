package com.notepad.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.notepad.app.model.Note;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotepadService {

	private final Map<Long, Note> noteRepo;
	
	public void createNote(Note note) {
		noteRepo.put(note.getId(), note);
		log.info("note created successfully");
	}
	
	public void deleteNote(long id) {
		noteRepo.remove(id);
		log.info("note deleted successfully");
	}
	
	public void editNote(long id, Note note) {
		noteRepo.put(id, note);
		log.info("note edited successfully");
	}
	
	public Note getNote(Long id) {
		return noteRepo.get(id);
	}
	
	public List<Note> getAllNotes(){
		List<Note> allNotes = new ArrayList<>();
		noteRepo.forEach((k,v) -> {
			allNotes.add(v);
		});
		return allNotes;
	}
}
