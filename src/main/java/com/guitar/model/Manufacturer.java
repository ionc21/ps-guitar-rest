package com.guitar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@Entity
@NamedNativeQuery(name = "Manufacturer.getAllThatSellAcoustics", query = "SELECT m.id, m.name, m.foundedDate, m.averageYearlySales, m.location_id as headquarters_id, m.active "
		+ "FROM Manufacturer m " + "LEFT JOIN Model mod ON (m.id = mod.manufacturer_id) " + "LEFT JOIN ModelType mt ON (mt.id = mod.modeltype_id) "
		+ "WHERE (mt.name = ?)", resultClass = Manufacturer.class)
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;

	@Column(name = "FOUNDEDDATE")
	private Date foundedDate;

	@AssertTrue
	@Column(name = "AVERAGEYEARLYSALES")
	private BigDecimal averageYearlySales;
	private Boolean active;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "manufacturer_id")
	private List<Model> models = new ArrayList<>();

	@ManyToOne
	private Location headquarters;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Date getFoundedDate() {
		return foundedDate;
	}

	public void setFoundedDate(final Date foundedDate) {
		this.foundedDate = foundedDate;
	}

	public BigDecimal getAverageYearlySales() {
		return averageYearlySales;
	}

	public void setAverageYearlySales(final BigDecimal averageYearlySales) {
		this.averageYearlySales = averageYearlySales;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(final List<Model> models) {
		this.models = models;
	}

	public Location getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(final Location headquarters) {
		this.headquarters = headquarters;
	}

	public Long getId() {
		return id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(final Boolean active) {
		this.active = active;
	}
}
