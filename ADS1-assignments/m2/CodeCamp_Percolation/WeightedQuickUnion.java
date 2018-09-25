class WeightedQuickUnion {
	private int[] array;
	private int[] rootCount;
	WeightedQuickUnion(int length) {
		array = new int[length];
		rootCount = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = i;
			rootCount[i] = 1;
		}
	}
	public int rootOf(int number) {
		System.out.println(number);
		while (number != array[number]) {
			number = array[number];
		}
		return number;
	}
	public void union(int a, int b) {
		int rootValueA = rootOf(a);
		int rootValueB = rootOf(b);
		if (rootCount[rootValueA] < rootCount[rootValueB]) {
			array[rootValueA] = rootValueB;
			rootCount[rootValueB] += rootCount[rootValueA];
		} else {
			array[rootValueB] = rootValueA;
			rootCount[rootValueA] += rootCount[rootValueB];
		}
	}
	public boolean connectedTo(int a, int b) {
		return rootOf(a) == rootOf(b);
	}
}
