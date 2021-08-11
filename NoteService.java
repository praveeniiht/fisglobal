package com.example.noteservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.noteservice.model.CommentDto;
import com.example.noteservice.model.Notestab;



@Transactional
public interface NoteService {
	public List<Notestab> findAll();
	public Notestab addNote(Notestab notes);
	public void deleteNote(Notestab notes);
	public Optional<Notestab> findById(int id);
	public List<Notestab> findByAuthor(String author);
	public List<Notestab> findByTitle(String title);
	public List<CommentDto> findCommentsById(int id);
}
