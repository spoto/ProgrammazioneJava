
public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		int a = 5;
		t.foo(a);
		System.out.println("a = " + a);
	}

	public void foo(int n) {
		n = n + 1;
		System.out.println("n = " + n);
	}
}
