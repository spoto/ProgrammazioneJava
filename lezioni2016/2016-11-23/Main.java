import it.univr.tree.BinaryTree;

public class Main {

	public static void main(String[] args) {
		BinaryTree tree =
			new BinaryTree(11,
	
				new BinaryTree(-4,
					null,
					new BinaryTree(-7)
				),
	
				new BinaryTree(3,
					new BinaryTree(13),
					new BinaryTree(22)
				)
			);

		System.out.println(tree.toString());
		System.out.println("max = " + tree.max());
		System.out.println("min = " + tree.min());
		System.out.println("sum = " + tree.sum());
	}
}
