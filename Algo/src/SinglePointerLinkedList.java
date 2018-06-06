import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
public class SinglePointerLinkedList<T> {
	
	
	protected class Node<T>
	{
		
		public Node(T value) {
			this.value = value;
		}
		T value;
		Node<T> next;
		public boolean hasNext() {
			return next!=null;
		}
	}
	
	private Node<T> getInstance(T value){
		return new Node<T>(value);
	}
	
	
	private void iterateTillTheTail(BiConsumer<Node<T>,Node<T>> processConsumer,
			BiConsumer<Node<T>,Node<T>> postConsumer) {
		if(root == null) return;
		Node<T> parent = null;
		Node<T> node = root;
		
		while(node.hasNext()) {
			parent = node;
			node = node.next;
			if(processConsumer != null)
			processConsumer.accept(parent, node);
		}
		if(postConsumer != null)
		postConsumer.accept(parent, node);
		
	}
	
	private Node<T> root;
	public void add(T value) {
		if(root == null) {
			root = getInstance(value);
		}else {
			iterateTillTheTail(null, (root,node)->{node.next = getInstance(value);});
		}
	
	}
	
	public void remove(T object) {
		
		if(root == null) return;
		iterateTillTheTail((parent,node)->{
			if(node.value.equals(object)) {
				parent.next = node.next;
				node.value = null;
			}
			},null);
	}
	
	public int size() {
		if (root == null)
			return 0;
		else {
			AtomicInteger count = new AtomicInteger(1);
			iterateTillTheTail((parent, node) -> {
				count.incrementAndGet();
			}, null);
			return count.get();

		}
		}
	
	public static void main(String[] args) {
		SinglePointerLinkedList<String> llString = new SinglePointerLinkedList<String>();
		llString.add("this");
		System.out.println(llString.size());
		llString.add("is");
		System.out.println(llString.size());
		llString.add("sample");
		System.out.println(llString.size());
		llString.add("testing");
		System.out.println(llString.size());
	}
	
}
