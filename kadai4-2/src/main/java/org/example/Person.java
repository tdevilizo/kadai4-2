package org.example;
import java.time.LocalDate;

public class Person{
    private String name;
    private LocalDate birthday;

    //↓コンストラクター
    public Person(String name, LocalDate birthday) {
        this.name = name;//メンバー変数①
        this.birthday = birthday;//メンバー変数②
    }
    //↓ゲッター
    public String getName() {
        return this.name;
    }
    public LocalDate getBirthday() {
        return this.birthday;
    }
}
