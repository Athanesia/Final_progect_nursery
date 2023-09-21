public class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count > 0) {
            System.out.println("Resource properly closed.");
        } else {
            throw new Exception("Resource not used or left open.");
        }
    }
}