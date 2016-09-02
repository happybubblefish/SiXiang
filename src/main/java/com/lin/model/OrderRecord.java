package com.lin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class OrderRecord {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="order_id") 
    @OrderColumn(name = "dishLine_index")
	private List<DishLine> dishLines = new ArrayList<DishLine>();
	
	public List<DishLine> getDishLines() {
		return dishLines;
	}

	public void setDishLines(List<DishLine> dishLines) {
		this.dishLines = dishLines;
	}

	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public List<DishLine> getTestArray() {
//		return testArray;
//	}
//
//	public void setTestArray(List<DishLine> testArray) {
//		this.testArray = testArray;
//	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
