package com.example.springbootdemo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "surveys")
public class Survey {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "people_answered")
	private int peopleAnswered;
	@Column(name = "mentioned_prof")
	private int mentioned_prof;
	@Column(name = "list_of_scores")
	private String listOfScores;
	@Column(name = "list_of_questions")
	private String listOfQuestions;
	
	public Survey() {}
	
	public Survey(int peopleAnswered, int mentioned_prof, String listOfScores,
			String listOfQuestions) {
		super();
		this.peopleAnswered = peopleAnswered;
		this.mentioned_prof = mentioned_prof;
		this.listOfScores = listOfScores;
		this.listOfQuestions = listOfQuestions;
	}
	
	public int getPeopleAnswered() {
		return peopleAnswered;
	}
	
	public void setPeopleAnswered(int peopleAnswered) {
		this.peopleAnswered = peopleAnswered;
	}
	
	public int getMentioned_prof() {
		return mentioned_prof;
	}
	
	public void setMentioned_prof(int mentioned_prof) {
		this.mentioned_prof = mentioned_prof;
	}
	
	public String getListOfScores() {
		return listOfScores;
	}
	
	public void setListOfScores(String listOfScores) {
		this.listOfScores = listOfScores;
	}
	
	public String getListOfQuestions() {
		return listOfQuestions;
	}
	
	public void setListOfQuestions(String listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Survey [peopleAnswered=" + peopleAnswered + ", mentioned_prof=" + mentioned_prof + ", listOfScores="
				+ listOfScores + ", listOfQuestions=" + listOfQuestions + "]";
	}

	

}
