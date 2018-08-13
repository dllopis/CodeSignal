package interview;

import java.util.Stack;

public class SimplifyPath {
		
		public String simplifyPath(String path)	{
			
			
			Stack<String> stack = new Stack<>();
			
			// split original string using delimeter '/' and any following '/'
			String[] paths = path.split("/+");
			
			// iterate using for each loop and checking for cases
			/*
			 *  / 	= root directory
			 *  / represents directory separator
			 *  // 	= change directory
			 *  . 	= current directory
			 *  .. 	= mark parent directory
			 *  corner case for .. if parent = does nothing
			 */
			for(String s : paths)	{
				if(s.equals(".."))	{
					if(!stack.isEmpty())	{
						stack.pop(); // moving back a directory
					}
				}
				else if(!s.equals(".") && !s.equals(""))	{
					stack.push(s); // add characters one by one and ignore  '.' and space
				}
			}
			String result = "";
			
			// we can now start popping stack and appending results after in order to output simplified path
			while(!stack.isEmpty())	{
				result = "/" + stack.pop() + result;
			}
			// corner case of stacking being empty
			if(result.length() == 0)	{
				return "/";
			}
			return result;
			
		}
		public static void main(String[] args) {
			String path = "/home/a/./x/../b//c/";
			String newPath;
			
			SimplifyPath simplePath = new SimplifyPath();
			newPath = simplePath.simplifyPath(path);
			
			System.out.println("Original: " + path);
			System.out.println("Simplified: " + newPath);
		}

	}

