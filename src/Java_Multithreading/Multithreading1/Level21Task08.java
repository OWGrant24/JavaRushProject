package Java_Multithreading.Multithreading1;

/*
Клонирование растений
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуй механизм глубокого клонирования для Tree.
*/

import java.util.Arrays;

public class Level21Task08 {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        clone = (Tree) tree.clone();

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Object clone() {
            String[] branchesClone = branches.clone();
            return new Tree(getName(),branchesClone);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tree tree = (Tree) o;

            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(branches, tree.branches);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }
    }
}