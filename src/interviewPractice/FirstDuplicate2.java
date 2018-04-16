package interviewPractice;

public class FirstDuplicate2 {

	
	static int[] a = {2,3,3};
	
	public static int firstDuplicate(int[] a) {
		
		if(a.length==1)
			return -1;
		
		int[] b = new int[a.length];
		
		int firstDuplicate = -1;
		int checkDuplicate;
		
		int pointer1 = 0;
		int pointer2 = 1;
		
		for(int i = 0; i < a.length;i++)
		{
			b[i] = a[i];
		}
		
		
		for(int i = pointer1;i<a.length;i++)
		{
			if(pointer1 == pointer2 && firstDuplicate == -1)
				return -1;
			
			System.out.println("a: " +pointer1 + "\tb: " + pointer2);
			
			if(a[pointer1] == b[pointer2])
			{
				if(firstDuplicate == -1)
				{
					firstDuplicate = pointer2;
					System.out.println("First Duplicate position: " + pointer2 + "\t" + "Value: " + a[pointer2]);
					pointer1++;
					pointer2 = pointer1 + 1;
					i=pointer1;
					continue;
				}
				
				checkDuplicate = pointer2;
				
				if(checkDuplicate < firstDuplicate && checkDuplicate != -1)
				{
					firstDuplicate = checkDuplicate;
					System.out.println("First Duplicate position: " + pointer2 + "\t" + "Value: " + a[pointer2]);
					pointer1++;
					pointer2 = pointer1 + 1;
					i=pointer1;
					continue;
				}
			}
			
			if(pointer2 < a.length -1)
				pointer2++;
			else
				pointer1++;
		}
		
		
		if(firstDuplicate == -1)
			return -1;
		
		return a[firstDuplicate];
	}
	public static void main(String[] args) {
		
		System.out.println(firstDuplicate(a));
	}

}
