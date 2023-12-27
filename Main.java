package ru.itis.inf304.linkedlist;

import java.util.Scanner;

public class Main {
    static Node head;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество n элементов в списке: ");
        int n = scanner.nextInt();

        System.out.println("Введите элементы списка: ");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.input(data);
        }
        System.out.println("Оригинальный список: ");
        list.PrintList();
        System.out.println();

        System.out.print("Введите индекс для ввода нового элемента: ");
        int index = scanner.nextInt();
        if (index>n) {
            System.out.println("Введен неверный индекс");
            return;}
        System.out.print("Введите новый элемент для ввода: ");
        int elementToAdd = scanner.nextInt();
        list.addAtIndex(index, elementToAdd);
        System.out.println("Список после добавление элемента по индексу " + index + ":");
        list.PrintList();

        list.sort();
        System.out.println();
        System.out.println("Отсортированный список: ");
        list.PrintList();
        System.out.println();

        System.out.print("Введите индекс для удаления элемента в списке: ");
        int index_del = scanner.nextInt();
        if (index_del>n) {
            System.out.println("Введен неверный индекс");
            return;}
        list.removeElem(index_del);
        System.out.println("Список после удаления " + index_del + "  элемента: ");
        list.PrintList();
    }
}