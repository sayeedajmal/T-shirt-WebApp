package com.Strong.Tshirt_Web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "show_Categories", query = "select c from Categories c")
public class Categories {
    @Id
    @GeneratedValue
    private Integer category_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String Description;

    public Categories() {

    }

    public Categories(String name, String description) {
        this.name = name;
        Description = description;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Categories [category_id=" + category_id + ", name=" + name + ", Description=" + Description + "]";
    }

}
