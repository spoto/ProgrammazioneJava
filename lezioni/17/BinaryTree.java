
public class BinaryTree {
	  private int value;
	  private BinaryTree left;
	  private BinaryTree right;

	  public BinaryTree(int value, BinaryTree left, BinaryTree right) {
		  this.value = value;
		  this.left = left;
		  this.right = right;
	  }

	  public BinaryTree(int value) {
		  this.value = value;
	  }

	  public String toString() {
		  return toStringWithSpaces("");
	  }

	  /**
	   * Stampa l'albero con la radice a sinistra e spostato
	   * verso destra degli spazi indicati come parametro.
	   */

	  private String toStringWithSpaces(String spaces) {
		  String res = "";

		  if (right != null)
			  res += right.toStringWithSpaces(spaces + "  ");

		  res += spaces + value + "\n";

		  if (left != null)
			  res += left.toStringWithSpaces(spaces + "  ");

		  return res;
	  }

	  public String toStringHorizontally() {
		  int height = height();
		  int slots = (1 << height) - 1;

		  String res = "";
		  for (int row = 0; row < height; row++)
			  res += getRow(row, slots) + '\n';

		  return res;
	  }

	  private String getRow(int row, int slots) {
		  // slots è sempre dispari!
		  int half = (slots - 1) / 2;

		  if (row == 0)
			  return spacesFor(half) + String.format(" %2d", value) + spacesFor(half);
		  else {
			  String leftRow = left != null ? left.getRow(row - 1, half) : spacesFor(half);
			  String rightRow = right != null ? right.getRow(row - 1, half) : spacesFor(half);

			  return leftRow + spacesFor(1) + rightRow;
		  }
	  }

	  private String spacesFor(int repetitions) {
		  String res = "";
		  while (repetitions-- > 0)
			  res += "   ";

		  return res;
	  }

	private int height() {
		  if (left != null && right != null)
			  return 1 + Math.max(left.height(), right.height());
		  else if (left != null)
			  return 1 + left.height();
		  else if (right != null)
			  return 1 + right.height();
		  else
			  return 1;
	  }

	  public int sum() {
		  int res = value;

		  if (left != null)
			  res += left.sum();

		  if (right != null)
			  res += right.sum();

		  return res;
	  }

	  public int max() {
		  int res = value;

		  if (left != null)
			  res = Math.max(res, left.max());

		  if (right != null)
			  res = Math.max(res, right.max());

		  return res;
	  }

	  public static void main(String[] args) {
		  BinaryTree t = new BinaryTree
		  	(11,
		  		new BinaryTree(-4, null, new BinaryTree(-7)),
		  		new BinaryTree(3, new BinaryTree(13, new BinaryTree(18), null), new BinaryTree(22)));

		  System.out.println(t.toString());
		  System.out.println(t.toStringHorizontally());
	  }
}