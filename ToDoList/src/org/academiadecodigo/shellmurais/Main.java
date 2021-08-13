package org.academiadecodigo.shellmurais;

public class Main {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        for (int i = 0; i < 20; i++) {
            switch ((int) (Math.random() * 3)) {
                case 0: todoList.add(new TodoList.TodoItem(Importance.HIGH, todoList.getNHigh(), ("High priority " + todoList.getNHigh())));
                        break;

                case 1: todoList.add(new TodoList.TodoItem(Importance.MEDIUM, todoList.getNMedium(), ("Medium priority " + todoList.getNMedium())));
                        break;

                case 2: todoList.add(new TodoList.TodoItem(Importance.LOW, todoList.getNLow(), ("Low priority " + todoList.getNLow())));
                        break;

            }

        }

        int index = 1;
        while (!todoList.isEmpty()) {
            if (index < 10) {
                System.out.println("[0" + (index++) + "] " + todoList.remove().getItem());

            } else {
                System.out.println("[" + (index++) + "] " + todoList.remove().getItem());

            }

        }

    }

}
