public class IntegerListImpl implements IntegerList {
    private Integer[] array;
    private int size;

    public IntegerListImpl() {
        array =  new Integer[10];
    }

    public IntegerListImpl(int initialCapacity) {
        array = new Integer[initialCapacity];
    }
    private void validateItem (Integer item) {
        if (item == null){
            throw new NullItemException();
        }
    }
    private void validateSize(){
        if (size == array.length){
            throw new ArrayIsFullException();
        }
    }
    private void validateIndex (int index){
        if (index < 0 || index > size){
            throw new InvalidIndexException();
        }
    }
}
