import java.util.stream.Stream;

public class IntegerLinkedList {
	static int x = 0;
	public static void main(String[] args) {
		SinglePointerLinkedList<Integer> integerlinkedList = new SinglePointerLinkedList<Integer>();
		Stream.generate(()->x++).limit(3000).forEach((a)->integerlinkedList.add(a));
		System.out.println(integerlinkedList.size());
		//Stream.generate(()->integerStack.pop()).limit(200).forEach((x)->System.out.println(x));
	}
}
