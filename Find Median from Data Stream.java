class MedianFinder {

    private List<Integer> list;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        int insertionIndex = Collections.binarySearch(list, num);
        if (insertionIndex < 0) {
            insertionIndex = Math.abs(insertionIndex + 1);
            list.add(insertionIndex, num);
        } else {
            list.add(insertionIndex, num);
        }
    }
    
    public double findMedian() {
        int index = list.size() / 2;
        if (list.size() % 2 > 0) {
            return Double.valueOf(list.get(index));
        }
        
        double median = (list.get(index) + list.get(index - 1)) / 2.0;
        return Math.round(median * 100000) / 100000D;
    }
}
