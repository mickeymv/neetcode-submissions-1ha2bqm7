class Solution {

    List<List<Integer>> triangle = new ArrayList<>();

    public List<Integer> getRow(int rowIndex) {
        

        triangle.add(List.of(1));
        triangle.add(List.of(1,1));
        triangle.add(List.of(1,2,1));
        triangle.add(List.of(1,3,3,1));
        triangle.add(List.of(1,4,6,4,1));

        return triangle(rowIndex);
    }

    public List<Integer> triangle(int rowIndex) {
        if (rowIndex<triangle.size()) {
            return triangle.get(rowIndex);
        }

        List<Integer> rowBefore = triangle(rowIndex-1);

        System.out.println("Row before is " + rowBefore);

        List<Integer> row = new ArrayList<>();

        row.add(1);//first element , 0th index

        System.out.println("Row now is " + row);

        for(int i=1;i<rowIndex;i++) {
            System.out.println("Adding index " + i);
            row.add(rowBefore.get(i-1)+rowBefore.get(i));
            System.out.println("Row now is " + row);
        }

        row.add(1);//last element , rowIndex'th element  
        System.out.println("Row now is " + row);

        triangle.add(row);

        return triangle.get(rowIndex);
    }
}