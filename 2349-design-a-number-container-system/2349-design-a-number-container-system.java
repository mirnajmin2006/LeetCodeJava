
class NumberContainers {

    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> sets = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {

        if (map.containsKey(index)) {
            int old = map.get(index);
            sets.get(old).remove(index);
        }

        map.put(index, number);

        sets.putIfAbsent(number, new TreeSet<>());
        sets.get(number).add(index);
    }

    public int find(int number) {
        if (!sets.containsKey(number) || sets.get(number).isEmpty()) {
            return -1;
        }

        return sets.get(number).first();
    }
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */