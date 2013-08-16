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

public class PlayerChar {
	public List<String> classes;
	public Race race;
	public int size; // 0=med, -1=small, 1=large, etc...
	public List<String> description;
	public String align;
	/* 			lawful	netural	chaotic
	 * good: 	0		1		2
	 * neutral:	3		4		5
	 * evil:	6		7		8
	 */
	
	public int baseattack;
	public Var movespeed;
	public List<Stat> stats;
	public List<Var> saves;
	public List<Var> skills;
	public List<Var> defences;//for various statistics such as DR or resistances
	public List<Var> offences;//for various attack bonuses
	
	public List<Ability> abils;
	public List<Special> spec;
	
	public List<Item> items;
	public List<Equipment> equip;
	
	public String notes;
	
	public Stat get_stat( String name ){
		Stat tmp;
		for( int i=0;i<stats.size();i++)
		{
			tmp =stats.get(i);
			if( tmp.name.equals(name) )
				return tmp;
		}
		return null;
	}
}
