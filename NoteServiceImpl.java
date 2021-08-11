package com.example.noteservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.noteservice.dao.NotesDao;
import com.example.noteservice.model.CommentDto;
import com.example.noteservice.model.Notestab;

@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	NotesDao dao;
	
	@Autowired
	RestTemplate template;
	public final String baseurl = "http://localhost:8082/comments/id/";
	@Override
	public List<Notestab> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Notestab addNote(Notestab notes) {
		// TODO Auto-generated method stub
		return dao.save(notes);
	}

	@Override
	public void deleteNote(Notestab notes) {
		// TODO Auto-generated method stub
		dao.delete(notes);
		
	}

	@Override
	public Optional<Notestab> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Notestab> findByAuthor(String author) {
		// TODO Auto-generated method stub
		List<Notestab> ars = dao.findAll();
		List<Notestab> authors = new ArrayList();
		for(Notestab a:ars) {
			if(a.getAuthor().equals(author)) {
				authors.add(a);
			}
		}
		return authors;
	}

	@Override
	public List<Notestab> findByTitle(String title) {
		// TODO Auto-generated method stub
		List<Notestab> t = dao.findAll();
		List<Notestab> titles = new ArrayList();
		for(Notestab temp: t) {
			if(temp.getTitle().equals(title)) {
				titles.add(temp);
			}
		}
		return titles;
	}

	@Override
	public List<CommentDto> findCommentsById(int id) {
		// TODO Auto-generated method stub
		ResponseEntity<ArrayList> responseEntity = 
				template.getForEntity("http://COMMENTSERVICE/comments/note/"+id, ArrayList.class);
		 List<CommentDto> dtos = responseEntity.getBody();
		
		 return dtos;
	}

}
