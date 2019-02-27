/**@CopyRight 2019 J Technologies All Rights are Reserved.
 * you should disclose the information outside,otherwise
 * terms and conditions will be apply.
 */
package com.jyotish.test;

/**
 * @author Jyotish kumar
 *
 * @Feb 27, 2019
 */
public class MainClass {
	 public static void main(String[] args) {
		
		 try
			{
			
			ReadingFile tobject=new ReadingFile();
			tobject.readFile();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
	}

}
