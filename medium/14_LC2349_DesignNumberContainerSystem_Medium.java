// LeetCode 2349 - Design a Number Container System
// Topic: Classes, objects and methods
import java.util.*;

class NumberContainers {
    private final Map<Integer, Integer> indexToNumber = new HashMap<>();
    private final Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        Integer oldNumber = indexToNumber.get(index);

        if (oldNumber != null) {
            TreeSet<Integer> oldIndices = numberToIndices.get(oldNumber);
            oldIndices.remove(index);
            if (oldIndices.isEmpty()) 
                numberToIndices.remove(oldNumber);
            }
        }

        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, key -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> indices = numberToIndices.get(number);
        return (indices == null || indices.isEmpty()) ? -1 : indices.first();
    }
}
