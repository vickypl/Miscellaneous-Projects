import javax.servlet.*;
import java.util.*;
import java.io.*;

public class WordServ extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		Random rand = new Random();
		PrintWriter out = response.getWriter();
		Date date = new Date();

		String word=request.getParameter("word");

		int length=word.length();

		boolean isPalin=isPalindrome(word);

		String rv=word;
		char[] arr=rv.toCharArray();
		rev(arr, 0, length-1);
		String reversed = Arrays.toString(arr);

		response.setContentType("text/html");


		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("This is Student Servolet...");
		out.print("</title>");
		out.print("</head>");
		out.print("<body style='color: white; background: black;'>");
		out.print("<h1><a style='color: white;' href='index.html'>Home</a></h1>");
		out.print("<hr>");
		out.print("<h2>"+date+"</h2>");
		out.print("<center>");
		out.print("<fieldset style='height: 270px; width: 400px;'>");
		out.print("<hr>");
		out.print("<h2> Given Word:: "+word+"</h2>");
		out.print("<hr>");
		out.print("<h2> Word Length: "+length+"</h2>");
		out.print("<hr>");
		if (isPalin) {
			out.print("<h2>"+word+" is Palindrome.."+"</h2>");
		} else {
			out.print("<h2>"+word+" is Not a Palindrome.."+"</h2>");
		}
		out.print("<hr>");
		out.print("<h2> Reverse of word : "+reversed+"</h2>");
		out.print("<hr>");
		out.print("</fieldset>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
	}

	public static boolean isPalindrome(String string) {

		boolean isTrue=false;
		String stringTwo=string;

		char[] arr1=string.toCharArray();
		rev(arr1, 0, arr1.length-1);

		char[] arr2=stringTwo.toCharArray();

		String strOne=Arrays.toString(arr1);
		String strTwo=Arrays.toString(arr2);

		if (strTwo.equals(strOne)) {
			isTrue=true;
		} else {
			isTrue=false;
		}

		return isTrue;
	}


	public static void rev(char[] arr, int start, int end) {

		int mid=(start+end)/2;
		if (start>mid) {
			return;
		}
		char temp = arr[start];
		arr[start]=arr[end];
		arr[end]=temp;

		rev(arr, start+1, end-1);

	}
}