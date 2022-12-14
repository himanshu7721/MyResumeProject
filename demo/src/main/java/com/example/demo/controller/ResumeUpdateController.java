package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Education;
import com.example.demo.entity.Projects;
import com.example.demo.entity.Resume;
import com.example.demo.service.AllResumesService;
import com.example.demo.service.UpdateService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ResumeUpdateController {
	
	@Autowired
	UpdateService updateservice;
	
	@Autowired
	AllResumesService resumeservice;
	
	@GetMapping("/getresume")
	public List<Resume> getallResumes()
	{
		return resumeservice.getAllResume();
	}
	@PostMapping("/getEducation")
	public List<Education> getEducation(@RequestBody Resume resume)
	{
		return resumeservice.getAllEducation(resume);
	}
	
	@PostMapping("/getProjects")
	public List<Projects> getProjects(@RequestBody Resume resume)
	{
		return resumeservice.getAllProjects(resume);
	}
	
	//@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@PutMapping("/updateemail/{id}")
	public ResponseEntity<Resume> updatefunc(@PathVariable("id") long id, @RequestBody Resume resume)
	{
		return updateservice.updateemail(id,resume);
		
	}
	

}
