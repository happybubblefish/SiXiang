package com.lin.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "authority")
public class Authority {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="authorities")
    private Set<UserCredentials> userCredentials;

	public Set<UserCredentials> getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(Set<UserCredentials> userCredentials) {
		this.userCredentials = userCredentials;
	}

	public Authority(){}
    
    public Authority(Authority au){
    	this.id = au.getId();
    	this.name = au.getName();
    	this.userCredentials = au.getUserCredentials();
    }
    
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

    
}
