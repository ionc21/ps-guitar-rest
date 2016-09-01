package com.guitar.model.projections;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.guitar.model.Model;
import com.guitar.model.ModelType;

@Projection(name = "modelDetailView", types = { Model.class })
public interface ModelDetailView {

	@Value("#{target.name}")
	String getModelName();

	BigDecimal getPrice();

	int getFrets();

	@Value("#{target.manufacturer.name}")
	String getManufacturerName();

	ModelType getModelType();

	String getWoodType();

	@Value("#{target.manufacturer.name.split(' ')[0]} #{target.name}")
	String getFullName();

}
