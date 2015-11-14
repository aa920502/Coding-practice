// Coding: implement hash table in java/python.
// Requirements: implement public void put(K key, V value); public V get(K key); 

public class HashMap<K, V> {】
        private static int DEFAULT_CAPACITY = 32;
        private static double A = (Math.pow(5, 0.5) - 1) / 2;、

        private int capacity;

        private Node<K, V>[] buckets;

        public HashMap() {
            this(DEFAULT_CAPACITY);
        }

        @SuppressWarnings("unchecked")
        public HashMap(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("illegal input");
            int temp = 1;
            while (temp < capacity) {
                temp <<= 2;
            } 
            this.capacity = temp;

            buckets = new Node[this.capacity];
        }

        
        public void put(K key, V value) {
            if (key == null) {
                throw new IllegalArgumentException("key can not be null");
            }
            int position = index(key);

            Node<K, V> node = buckets[position];
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            Node<K, V> newNode = new Node<K, V>(key, value);
            if (buckets[position] != null) {
                newNode.setNext(buckets[position]);
            }
            buckets[position] = newNode;
        }

        
        public V get(K key) {
            if (key == null) {
                throw new IllegalArgumentException("key can not be null");
            }
            int position = index(key);
            Node<K, V> node = buckets[position];
            while (node != null) {
                if (node.key.equals(key)) {
                        return node.value;
                }
                node = node.next;
            }	
            return null;
        }
        
        private int index(K key) {
            int hashCode = key.hashCode();
            double temp = hashCode * A;
            double digit = temp - Math.floor(temp);
            return (int) Math.floor(digit * capacity);
        }

        static class Node<K, V> {
            private final K key;
            private V value;
            private Node<K, V> next;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public void setNext(Node<K, V> next) {
                this.next = next;
            }
        }