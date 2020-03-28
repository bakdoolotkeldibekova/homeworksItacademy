class Greatest {
    public static <T extends Comparable<T>> T greatest(T[] arr) {
        T max = arr[0];

        for(int i=1; i<arr.length; i++){
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] integers = {5, 9, 3, 8};
        System.out.println(greatest(integers));
    }
}
