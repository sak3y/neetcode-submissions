class DynamicArray {
    int[] array;
    int size;

    public DynamicArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }  

    public void pushback(int n) {
        if (size == array.length) resize();
        array[size] = n;
        size++;
    }

    public int popback() {
        size--;
        return array[size];
    }

    private void resize() {
        int[] temp = new int[2 * array.length];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }
}

/*
    Sizable array: Design a custom array list in java

    get
        get index i
    set
        update index i to n

    pushback  
        push element n to the end of the array
        ex. [1,2,3,4]
        push elemetn 2 to the end
        => [1,3,4,2]
        what's happend is all the elemetns after 2, we pushed 1 back
        and then we updated the last value to be 2

        1. Find elemetn n (handling dupes?)
        2. store it temporarily
        3. push all element after the index of n 1 back
        4. finally, update the last index wiht n


    popback
        pop element at end and return it
        since we can't change the size of the arrya, we aren't 'literally' popping
        instead, we update the value at that index to 0 and return it
    
    resize
        double the capacity of teh array
        we can't just do that with the exisitng array
        have to create a new array with 2 x cap
        assign all values in curr to new one

    getSize
        wil returh the number of elements in the array
        sicne arrays are 0 by default. Were gonna use this property to count elemetns that are greater than 0
        This assumes that 0 isn't a number insert into the array
    
    getCapacity
        returns size

*/