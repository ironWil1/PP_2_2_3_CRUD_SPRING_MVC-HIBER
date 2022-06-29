package ru.preproject.crud.model;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surName;
    @Column(name = "accountbalance")
    private long accountBalance;
    public User(){}

    public User(String name, String surName, long accountBalance) {
        this.name = name;
        this.surName = surName;
        this.accountBalance = accountBalance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
