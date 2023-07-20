package com.jessejputnam.movieAPI.Model;

public class Genre {
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Genre gen = (Genre) obj;
        return gen.getId() == id && gen.getName().equals(name);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Genre{id: " + id + ", name: " + name + "}";
    }
}
