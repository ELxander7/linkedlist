package ru.itis.inf304.linkedlist;

import org.w3c.dom.ls.LSOutput;

public class LinkedList {
    private Node head;
    public void input (int data) {
        Node newNode = new Node(data);//создали новый узел
        if (head == null) { //если голова(head)- пустое значение
            head = newNode; //голова будет то, что создали, новый узел newNode
        } else {
            Node current = head;//иначе текущий узел current равна голове (начало списка).
            while (current.next != null) {//пока не конец списка
                current = current.next;//переход к следующей ссылке (сохраняем в текущей узле сurrent значение ссылки на следующий узел).
            }
            current.next = newNode;///на последнем узле ссылку на следующий элемент присваиваем значение узла newNode (равен Null(т.е это последний узел))
        }
    }

    private void swap(Node e1, Node e2) {// меняем местами ссылки в узлах
        Node prev1 = findPrev(e1);//узел prev1 равен узлу со ссылкой е1 (current)
        Node prev2 = findPrev(e2);///узел prev2 равен узлу со ссылкой е2 (current.next следующий)
        if (prev1 != null) {//если узел prev1 не пустой
            prev1.next = e2;//в узле prev1 ссылка на следующий элемент равна значению е2 (current.next)
        } else {
            head = e2;//если узел prev1 пустой, то голова равна значению узлу е2 (current.next)
        }
        if (prev2 != null) {//если узел prev2 непустой
            prev2.next = e1; ///в узле prev2 ссылка на следующий элемент равна значению е1 (current)
        } else {
            head = e1;//если узел prev2 пустой, то голова равна значению узлу е1 (current)
        }
        // меняем местами ссылки на следующий элемент
        Node h = e1.next; // h равен ссылке на следующий элемент в узле е1
        e1.next = e2.next;//в узле е1 ссылка на следующий элемент равна ссылке на следующий элемент в узле е2
        e2.next = h;//в узле е2 ссылка на следующий элемент равна h
    }

    private Node findPrev(Node t) {//поиск узла в списке
        Node res = head;//устанавливаем ссылку нового узла res на текущий первый узел (голова)
        while (res != null && res.next != t) {//пока узел res не пустой (не конец списка) и ссылка на следующий узел не равна значению t
            res = res.next;//тогда переходим к следующей узлу
        }
        return res;//иначе (когда следующая ссылка будет равна значению t, то на выходе результат - res со ссылкой на следующий элемент
    }

    public void sort() {//сортировка
        Node end = null;//создаем узел, он пустой
        while (head.next != end) {//если в голове ссылка на следующий элемент не конец списка (не состоит нз одного элемента (голова))
            Node current = head; //устанавливаем ссылку нового узла current на текущий первый узел (голова)
            while (current.next != end) {//если ссылка на следующий элемент - не конец списка
                if (current.data > current.next.data) {// если значение текущего узла больше значения следующего узла
                    swap(current, current.next); //тогда меняем местами ссылки в узлах - метод swap
                } else {
                    current = current.next; // переходим к следующему узлу
                }
            }
            end = current;//если конец списка, то узел end равен текущему узлу
            //чтобы в конце списка отметитт что дальше конец списка
        }
    }

    public void PrintList() {
        Node current = head;//устанавливаем ссылку нового узла current на текущий первый узел (голова)
        while (current != null) {// пока не конец списка
            System.out.print(current.data + " ");
            current = current.next;//переход к следующему узлу
        }
    }
    public void addAtIndex(int index, int data) { // добавление нового узла в список
        Node newNode = new Node(data);//создаем узел newNode
        if (index == 0) {//если введенное значение равно 0
            newNode.next = head;//устанавливаем ссылку нового узла newNode на текущий первый узел
            head = newNode;//голова будет то, что создали newNode
        } else {
            Node current = head;//иначе устанавливаем, что  ссылка нового узла current равна ссылке на текущий первый узел (голова)
            for (int i = 0; i < index - 1; i++) { //цикл до предыдущего элемента к элементу, который хотим добавить
                if (current.next == null) {//если конец списка, то выходит сообщение
                    throw new IndexOutOfBoundsException("Индекс выходит за рамки");
                }
                current = current.next;//переходим к следующему узлу, текущий узел равен следующему узлу
            }
            newNode.next = current.next;//ссылка на новом узле(который будем добавлять) равна ссылке текущего узла,
            current.next = newNode;//ссылка текущего узла равна ссылке на новый узел(который мы добавляем.
        }
    }

    public Node removeElem(int index_del) { //удаление узла в списке
        Node current = head; // начинаем с головы текущего узла
        Node other = null; //вводим узел other, вначале он пустой (для хранения данных предыудущего узла)
        for (int i = 0; i < index_del; i++) { //до индекса элемента, который надо удалить
            if (current.next == null) { //если конец списка и мы не нашли индекс элемента, который надо удалить
                throw new IndexOutOfBoundsException("Индекс выходит за рамки");
            }
            other = current; //иначе, если не конец списка, то узел other(предыдущий) равен текущему узлу
            current = current.next; // текущий равен следующему, переходим к следующему узлу
        }
        if (current != null) { //если это не конец списка
            if (other == null) {//если узел other пустой, например, в списке только голова и предыдущего узла нет
                head = head.next;//переxодим к следующему элементу (null)
            } else {
                other.next = current.next; //ссылка на предыдущем узле будет равна ссылке на текущем узле, т.е на следующий узел
            }
        }
        return current;
    }
}