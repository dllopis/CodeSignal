package interviewPractice;

public class AreSimilar {

	boolean areSimilar(int[] a, int[] b) {
		
		int pointerA = 0;
		int pointerB = 0;
		int temp;
		boolean swapDone = false;
		
		while(pointerA < a.length && pointerB < b.length)	{
			System.out.println(
					"a[" + pointerA + "]:" + a[pointerA] + "\t" + "pointerA: " + pointerA
				  + "\t"
				  + "b[" + pointerB + "]:" + b[pointerB] + "\t" + "pointerB: " + pointerB
	  		);
			
			if(a[pointerA] == b[pointerB])	{
				pointerA++;
				pointerB++;
			}else	{
				if(swapDone)	{
					return false;
				}else	{
					while(pointerB < b.length)	{
						
						if(a[pointerB] == b[pointerB])	{
							pointerB++;
							continue;
						}
						
						if(a[pointerA] == b[pointerB])	{
							temp = b[pointerB];
							b[pointerB] = b[pointerA];
							b[pointerA] = temp;
							pointerB = pointerA;
							System.out.println("Swap performed -- start comparing again --");
							swapDone = true;
							break;
						}
						pointerB++;
					}
				}
				if(pointerB >= b.length && pointerA <= a.length)
					return false;
			}
		}	
		return true;
	}
	
	public void display(int[] a, String s)	{
		System.out.print(s);
		for(int i = 0;i<a.length;i++)	{
			System.out.print(a[i] + " ");
		}System.out.print(" ]\n");
	}
	public static void main(String[] args) {
		
		AreSimilar solution = new AreSimilar();
		
		int[] a = {2, 1, 2, 1, 1, 1, 2};
		int[] b = {1, 1, 2, 1, 2, 1, 2};
		
		System.out.println(solution.areSimilar(a, b));

	}

}
