package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.mysql.fabric.xmlrpc.base.Array;

@Entity
public class Category_Hlo {
	
@Id
private int category_id;
private String category_name;

@OneToMany(cascade=CascadeType.ALL)
private Set<Subcategory_Hlo> subCategory;

public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public String getCategory_name() {
	return category_name;
}
public void setCategory_name(String category_name) {
	this.category_name = category_name;
}
public Set<Subcategory_Hlo> getSubCategory() {
	return subCategory;
}
public void setSubCategory(Set<Subcategory_Hlo> subCategory) {
	this.subCategory = subCategory;
}

}
