package interviewPractice;

public class AddBorder {

	String[] addBorder(String[] picture) {
		String[] newPicture = new String[picture.length+2];
		String border = "";
		
		/* calculate full border of asterisk */
		int asteriskCount = picture[0].length() + 2;
		
		/* append asterisk count */
		for(int i = 0;i<asteriskCount;i++)	{
			border += "*";
		}
		
		// create new picture with border
		/* top border */
		newPicture[0] = border;
		
		/* original picture with asterisk on the sides of each string */
		for(int k = 1;k<newPicture.length-1;k++)	{
			newPicture[k] = "*" + picture[k-1] + "*";
		}
		
		/* bottom border */
		newPicture[newPicture.length-1] = border;
		
		return newPicture;
		}
	public void displayPicture(String[] s,String str)	{
		System.out.println(str);
		for(int i = 0;i<s.length;i++)	{
			System.out.println(s[i]);
		}
	}
	public static void main(String[] args) {
		String[] picture = {	
				"abc",
		        "ded"
		};
		
		AddBorder solution = new AddBorder();
		String[] result = solution.addBorder(picture);
		solution.displayPicture(picture,"-- Original Picture --");
		solution.displayPicture(result,"-- Bordered Picture --");
	}

}
