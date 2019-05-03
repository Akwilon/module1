package com.novikov.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Room {
    private List<? extends Toy> toys = new ArrayList<Toy>();
    private int age;
    private int money;

    public Room(int age) {
        setMoney(1000);
        setAge(age);
    }

    public Room(int money, int age) {
        this.money = money;
        setAge(age);
    }

    public List<? extends Toy> getToys() {
        return toys;
    }

    public void setToys(List<? extends Toy> toys) {
        this.toys = toys;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money > 0) {
            this.money = money;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return age == room.age &&
                money == room.money &&
                Objects.equals(toys, room.toys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toys, age, money);
    }

    @Override
    public String toString() {
        return "Room{" +
                "toys=" + toys +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
