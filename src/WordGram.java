/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Russell Meng
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		System.arraycopy(source, start, myWords, 0, size);
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Return the order of the WordGram
	 * @return
	 */
	public int length(){
		return myWords.length;
	}


	//@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram temp = (WordGram) o;
		if (!this.toString().equals(temp.toString())){
			return false;
		}
		return true;		
	}

	//@Override
	public int hashCode(){
		if (myHash == 0){
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		String[] temp = new String[myWords.length];
		System.arraycopy(myWords, 1, temp, 0, myWords.length-1);
		temp[myWords.length-1] = last;
		WordGram wg = new WordGram(temp,0,myWords.length);
		wg.toString();
		wg.hashCode();
		return wg;
	}

	//@Override
	public String toString(){
		if (myToString == null){
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
