package arcade;

public class DeleteDigit {

	int deleteDigit(int n) {
		String s = "" + n;
		char[] array = s.toCharArray();
		int max = 0;
		for(int i = 0;i<array.length;i++)	{
			String temp = "";
			System.out.print("Number: ");
			// delete a digit -- or in this case --
			// ignore the current digit/character in focus and concatenate the others
			for(int j = 0;j<array.length;j++)	{
				if(j == i)
					continue;
				System.out.print(array[j]);
				temp+=array[j];
			}System.out.println("");

			// update max
			if(Integer.parseInt(temp) > max)
				max = Integer.parseInt(temp);
		}

		return max;
	}
	public static void main(String[] args) {
		DeleteDigit solution = new DeleteDigit();
		System.out.println("Max: " + solution.deleteDigit(152));

	}

}
