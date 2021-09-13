package com.lucasmurilo.treinospring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToMany
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products = new ArrayList<>();

    public Category(){

    }

    public Category(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
