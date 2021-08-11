package com.example.noteservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteservice.model.CommentDto;
import com.example.noteservice.model.Notestab;
import com.example.noteservice.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {
	
	@Autowired
	NoteService service;
	
	
	@RequestMapping(value="/all")
	public List<Notestab> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Notestab addNote(@RequestBody Notestab notes) {
		return service.addNote(notes);
	}
	
	@RequestMapping(value="/del" ,method=RequestMethod.DELETE)
	public String deleteNote(@RequestBody Notestab notes) {
		
		service.deleteNote(notes);
		return "Notes deleted";
	}
	
	@RequestMapping(value="/id/{id}", method=RequestMethod.GET)
	public Optional<Notestab> findNotesById(@PathVariable Integer id)
	{
		return service.findById(id);
	}
	
	@RequestMapping(value="/{author}", method=RequestMethod.GET)
	public List<Notestab> findNotesByAuthor(@PathVariable String author){
		return service.findByAuthor(author);
	}
	
	@RequestMapping(value="/title/{title}", method=RequestMethod.GET)
	public List<Notestab> findNotesByTitle(@PathVariable String title){
		return service.findByTitle(title);
	}
	
	
	@RequestMapping(value="/comments/{id}", method=RequestMethod.GET)
	public List<CommentDto> findAllCommentsByNoteId(@PathVariable int id){
		return service.findCommentsById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
