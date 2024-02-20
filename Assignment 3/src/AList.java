
    public class AList<T> {
        private int maxSize;
        private int size;
        private T[] list;

        public AList() {
            maxSize = 0;
            size = 0;
            list = (T[]) new Object[maxSize];
        }

        void listAdd(T p) {
            if (size == maxSize) {
                maxSize = (maxSize + 1) * 2;
                T[]newList = (T[])new Object[maxSize];
                if (size >= 0) System.arraycopy(list, 0, newList, 0, size);
                list = newList;
            }
            list[size] = p;
            size++;
        }

        void listRemove(int pos) {
            boolean encountered = false;
            for (int i = 0; i < size; i++) {
                if (i == pos) {
                    encountered = true;
                }
                if (encountered) {
                    list[i] = list[i + 1];
                }
            }
            size--;
        }

        public String toString(){
            if(size == 0){
                return "Empty List\n";
            }
            String output = "";
            for (int i = 0; i<size; i++) {
                output += list[i].toString() + "\n";
            }
            return output;
        }
    }
