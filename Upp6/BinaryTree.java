package Upp6;
import java.util.Iterator;
import javax.xml.validation.Validator;

public class BinaryTree implements Iterable<Integer> {

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;
        
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        private void add(Integer key , Integer value ) {
            if ( this.key == key ) {
                this.value = value ;
                return;
            }
            if ( this.key > key ){
                if ( this.left != null ){
                    this.left.add(key, value );
                }
                else{
                    this.left = new Node (key , value );
                    //System.out.println("added: " + key);
                }
            }

            if ( this.key < key ){
                if ( this.right != null ){
                    this.right.add(key, value );
                }
                else{
                    this.right = new Node(key , value );
                    //System.out.println("added: " + key);
                }
            }
        }
        
        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
        
    }

    Node root;
    public BinaryTree() {
        root = null;
    }

    public void add ( Integer key , Integer value ) {
        if ( root == null ){
            root = new Node (key, value );
        }
        else{
            root.add(key, value);
        }
    }

    public int lookup (Integer  key){
        Node current = this.root;
        while (current != null) {
            if ( current.key == key ){
                return current.value ;
            }
            if ( current.key < key ){
                current = current.right ;
            }
            else{
                current = current.left ;
            }
        }
        return 0; 
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }

}
