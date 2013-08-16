/*
  The MIT License (MIT)

Copyright © 2013 Alexander Steiert

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
______________________________________________________________________________
 */

package steiert.chargen;

import java.util.List;

public class Bonus {
	public String name;
	public int typ;//bonus type
	public int amount;
	
	//for purposes of locating where to insert bonus into, only used by 'givers'
	public int place;//i.e. the type inside prequisite 
	
	Bonus( Bonus bns, String name){
		this.name = name;
		this.typ = bns.typ;
		this.amount = bns.amount;
		this.place = bns.place;
	}
	
	//helper function for 
	public static int getBonus(List<Bonus> bonus, List<Integer> skip, List<Integer> stack ){
		//doubt there will be anymore than 20
		final int size = 20;
		int [] types = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		boolean [] touched = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
		int result = 0;
		//
		
		for(int i=0;i<bonus.size();i++)
		{
			int typ = bonus.get(i).typ;
			int amount = bonus.get(i).amount;
			if( !skip.contains(typ) )
			{
				if( stack.contains(typ) )
					types[typ] += amount;
				else if( touched[typ] == false)
				{
					touched[typ] = true;
					types[typ] = amount;
				}
				else if(types[typ] < amount)
					types[typ] = amount;
			}
		}
		
		for(int i = 0; i < size; i++)
			result += types[i];
		
		return result;
	}
}