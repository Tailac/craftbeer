package com.beerhouse.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_ing")
	@SequenceGenerator(allocationSize = 1, name = "seq_ing", sequenceName = "seq_ing")
	@JsonIgnore
	private Integer id;

	@NotNull
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "ingredients")
	private Set<Beer> beers = new HashSet<>();

	public Ingredient() {
		super();
	}

	public Ingredient(Integer id, String description, Set<Beer> beers) {
		super();
		this.id = id;
		this.description = description;
		this.beers = beers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
