
public class Main
{
	public static void main(String[] args) {
		//String matching
		
		String txt = "abcdac";
		String pat = "x";
		int n = txt.length();
		int m = pat.length();
		int[] lps = new int[m];
		calculateLPS(m,pat,lps);
		int j=0,i=0;
		while((n-i)>=(m-j))
		{
		    if(pat.charAt(j)==txt.charAt(i))
		    {
		        i++;
		        j++;
		    }
		    if(j==m)
		    {
		        System.out.print("Match found");
		        break;
		    }
		    else if(i<n && pat.charAt(j)!=txt.charAt(i)){
		        if(j==0) i++;
		        else j = lps[j-1];
		       
		        
		    }
		}
		
	}
	public static void calculateLPS(int m, String pat, int[]lps)
	{
	    int i=1;
	    int len = 0;
	    lps[0] = 0;
	    while(i<m)
	    {
	        if(pat.charAt(len)==pat.charAt(i))
	        {
	            len++;
	            lps[i]=len;
	            i++;
	        }
	        else{
	            if(len!=0)
	            {
	                len = lps[len-1];
	            }
	            else{
	                lps[i]=len;
	                i++;
	            }
	        }
	    }
	}
}
