package com.company.MenuPack;

public class ShowMenu {
    public static void mainMenu() {
        System.out.println();
        System.out.println("1. Открыть таблицу \"Заводы\"");
        System.out.println("2. Открыть таблицу \"Партии\"");
        System.out.println("3. Открыть таблицу \"Продукция\"");
        System.out.println("4. Сформировать отчет ");
        System.out.println("5. Выход");
    }

    public static void secondMenu() {
        System.out.println();
        System.out.println("1. Добавить запись");
        System.out.println("2. Редактировать запись");
        System.out.println("3. Удалить запись");
        System.out.println("4. Просмотреть запись");
        System.out.println("5. Выход");

    }

    public static void fullInfoMenu() {
        System.out.println();
        System.out.println("1. Просмотреть отчет по № завода ");
        System.out.println("2. Просмотреть отчет за период");
        System.out.println("3. Полный отчет по всем таблицам");
        System.out.println("4. Выход");
    }
}
