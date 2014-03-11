public abstract class Clear {

	/*
	 * This method works like the "clear" bash command
	 */
	public static void clear() {
		for( int i = 0; i < 50; i++ ) {
			System.out.println("");
		}
		System.out.printf("%c[%d;%df", 0x1B, 0, 0);
	}
}
