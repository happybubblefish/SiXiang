package com.lin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Dish {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String pic;

	private String description;

	@OneToOne(fetch=FetchType.EAGER,  cascade = {CascadeType.PERSIST,CascadeType.REMOVE}) 
	@JoinColumn(name="kind_id")
	private Kind kind;
	
	private double price;

	private float discount;
	
	private boolean isChefRmd;
	
	@Min(value = 0)
	@Max(value = 3)
	private int spicyDegree;
	
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="dish_id") 
//    @OrderColumn(name = "comment_index")
	@OneToMany(mappedBy = "dish", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<Comment>();
	
	@Transient
	private int commentCount;

	private boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public boolean isChefRmd() {
		return isChefRmd;
	}

	public void setChefRmd(boolean isChefRmd) {
		this.isChefRmd = isChefRmd;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getCommentCount() {
		return this.comments.size();
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getSpicyDegree() {
		return spicyDegree;
	}

	public void setSpicyDegree(int spicyDegree) {
		this.spicyDegree = spicyDegree;
	}
}
