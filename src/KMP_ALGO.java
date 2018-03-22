import java.io.*;

class kmp
{
	int rat;
	
    public void KMPSearch(String pat)
    {
    	System.out.println("I got here");
        int M = pat.length();
        String txt;
		txt = new String();
        File inFile = new File("C:\\Users\\DELL\\Documents\\GitHub\\java_project\\src\\input.txt");
		FileReader ins = null;
		try
		{
			ins = new FileReader(inFile);
			int ch;
			while((ch = ins.read() ) != -1)
			{
				txt = txt+ (char)ch;
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(0);
		}
        int N = txt.length();
 
        int lps[] = new int[M];
        int j = 0;  // index for pat[]
 
        computeLPSArray(pat,M,lps);
 
        int i = 0;  // index for txt[]
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                System.out.println("Found pattern "+
                              "at index " + (i-j));
                rat = i-j;
                j = lps[j-1];
            }
 
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
    }
 
    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0
 
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                if (len != 0)
                {
                    len = lps[len-1];
 
                    // Also, note that we do not increment
                    // i here
                }
                else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
