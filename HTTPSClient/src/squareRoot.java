public class squareRoot {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 31;
		int i=1;
		for(i=1; i*i <= num; i++);
		int more = i;
		int less = --i;
		
//		int x = (less*less == num) ? less : Math.abs((more*more - num)) < Math.abs((less*less - num)) ? more : less;
		int x = (less*less == num) ? less : (more*more - num) < (num - less*less) ? more : less;
		System.out.println(x);
		num = 65;
		System.out.println((int) 'a');
		System.out.println((char) (++num+32));
	}
}
