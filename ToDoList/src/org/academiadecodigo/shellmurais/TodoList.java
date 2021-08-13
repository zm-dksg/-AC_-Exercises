package org.academiadecodigo.shellmurais;

import java.util.PriorityQueue;

public class TodoList {

    private static int nHigh    = 1;
    private static int nMedium  = 1;
    private static int nLow     = 1;

    PriorityQueue<TodoItem> todoList;

    public TodoList() {
        todoList = new PriorityQueue<>();

    }

    public void add(TodoItem todoItem) {
        todoList.add(todoItem);

    }

    public TodoItem remove() {
        return todoList.remove();

    }

    public boolean isEmpty() {
        return todoList.isEmpty();

    }

    public int getNHigh() { return nHigh; }
    public static void addNHigh() { nHigh++; }

    public int getNMedium() { return nMedium; }
    public static void addNMedium() { nMedium++; }

    public int getNLow() { return nLow; }
    public static void addNLow() { nLow++; }

    public static class TodoItem implements Comparable<TodoItem> {

        private final Importance importance;
        private final int priority;
        private final String item;

        public TodoItem(Importance importance, int priority, String item) {
            this.importance = importance;
            this.priority = priority;
            this.item = item;

            switch (importance) {
                case HIGH:      TodoList.addNHigh();
                                break;
                case MEDIUM:    TodoList.addNMedium();
                                break;
                case LOW:       TodoList.addNLow();
                                break;

            }

        }

        @Override
        public int compareTo(TodoItem todoItem) {
            int temp = this.importance.getImp() - todoItem.importance.getImp();
            if (temp != 0) { return temp; }

            temp = this.priority - todoItem.priority;
            return temp;

        }

        public String getItem() { return item; }

    }

}
