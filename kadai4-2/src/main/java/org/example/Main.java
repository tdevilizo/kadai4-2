package org.example;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("佐藤太郎", LocalDate.of(2015, 7, 14)));
        people.add(new Person("弧門一輝", LocalDate.of(2004, 10, 2)));
        people.add(new Person("平成尾張", LocalDate.of(2019, 4, 30)));
        people.add(new Person("令和一", LocalDate.of(2019, 5, 1)));
        people.add(new Person("早田進", LocalDate.of(1966, 7, 17)));
        people.add(new Person("ヒルマゲント", LocalDate.of(2023, 7, 8)));
        people.add(new Person("佐藤太郎", LocalDate.of(2017, 9, 3)));
        people.add(new Person("マドカダイゴ", LocalDate.of(1996, 9, 7)));
        people.add(new Person("大空大地", LocalDate.of(2015, 7, 14)));
        people.add(new Person("東光太郎", LocalDate.of(1973, 4, 3)));

        LocalDate firstShowaDate = LocalDate.of(1926, 12, 25);
        LocalDate firstHeiseiDate = LocalDate.of(1989, 1, 8);
        LocalDate firstReiwaDate = LocalDate.of(2019, 5, 1);

        System.out.println("誕生日順");
        // 昭和の日程のみフィルタ
        List<Person> showaBorn = people
                .stream()//MapをStreamに変換
                .filter(person -> person.getBirthday().isBefore(firstHeiseiDate) && person.getBirthday().isAfter(firstShowaDate) || person.getBirthday().isEqual(firstShowaDate))// 平成の初日より前の日付かつ昭和の初日より後、もしくは昭和の初日の日にち
                .sorted(Comparator.comparing(Person::getBirthday))
                .toList();
        showaBorn.forEach(person -> {
            System.out.println(person.getName()+":昭和" + (person.getBirthday().getYear() - firstShowaDate.getYear() + 1) + "年" + person.getBirthday().getMonthValue() + "月" + person.getBirthday().getDayOfMonth() + "日");//showaBirthdayのkeyとvalueを最初から順にすべて取り出す
        });
        // 平成の日程のみフィルター
        List<Person> heiseiBorn = people
                .stream()
                .filter(person -> person.getBirthday().isBefore(firstReiwaDate) && person.getBirthday().isAfter(firstHeiseiDate) || person.getBirthday().isEqual(firstHeiseiDate))// 令和の初日より前の日付かつ平成の初日より後、もしくは平成の初日の日にち
                .sorted(Comparator.comparing(Person::getBirthday))
                .toList();
        heiseiBorn.forEach(person -> {
            System.out.println(person.getName() +":平成"+ (person.getBirthday().getYear() - firstHeiseiDate.getYear() + 1) + "年" + person.getBirthday().getMonthValue() + "月" + person.getBirthday().getDayOfMonth() + "日");//heisiBirthdayのkeyとvalueを最初から順にすべて取り出す
        });
        // 令和の日程のみフィルター
        List<Person> reiwaBorn = people
                .stream()
                .filter(person -> person.getBirthday().isAfter(firstReiwaDate) || person.getBirthday().isEqual(firstReiwaDate))// 令和の初日より後、もしくは令和の初日の日にち
                .sorted(Comparator.comparing(Person::getBirthday))
                .toList();
        reiwaBorn.forEach(person -> {
            System.out.println(person.getName() +":令和"+ (person.getBirthday().getYear() - firstReiwaDate.getYear() + 1) + "年" + person.getBirthday().getMonthValue() + "月" + person.getBirthday().getDayOfMonth() + "日");//heisiBirthdayのkeyとvalueを最初から順にすべて取り出す
        });
    }
}


