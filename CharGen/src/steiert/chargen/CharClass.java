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

public class CharClass {

	public String name;
	public int skillgain;
	public List<Ability> abil;//class features and feats
	public List<Special> spec;//spells, psionics, and similiar
	public int save;//high saves:-1(),0(R),1(W),2(F),3(RW),4(RF),5(WF),6(WRF)
	public int attack;//0(1/2),1(3/4),2(full)
	public List<String> skills;
	
	public boolean isClassSkill( String skill ){
		boolean istrue = false;
		if(skills == null)
			return false;
		for(int i=0;i<skills.size() && !istrue;i++)
		{
			if(skills.get(i).equals(skill))
				istrue = true;
		}
		return istrue;
	}


}
