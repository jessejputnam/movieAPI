package com.jessejputnam.movieAPI.Model;

public class List {
    private int id;
    private String type;
    private String accountId;

    public List(int id, String type, String accountId) {
        this.id = id;
        this.type = type;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        List list = (List) obj;
        return list.getId() == id && list.getType().equals(type) && list.getAccountId().equals(accountId);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + id;
        result = result * prime + ((type == null) ? 0 : type.hashCode());
        result = result * prime + ((accountId == null) ? 0 : accountId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "List{id: " + id + ", type: " + type + ", accountId: " + accountId + "}";
    }
}
