class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>(List.of(1));
        }
        if (rowIndex == 1) {
            return new ArrayList<>(List.of(1, 1));
        }
        int size = rowIndex + 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> prevList = getRow(rowIndex - 1);
        for (int j = 1; j < size - 1; j++) {
            int elem = prevList.get(j - 1) + prevList.get(j);
            list.add(elem);
        }
        list.add(1);
        return list;

    }
}