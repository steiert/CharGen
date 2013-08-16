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

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class NewChar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_char);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_char, menu);
		return true;
	}
	
	public void skillchoice(View v) {
		String tmp;
		
		int str;
		int dex;
		int con;
		int inte;
		int wis;
		int cha;
		
		EditText stat;
		
		stat = (EditText) v.findViewById(R.id.editStr);
		if(stat.getText().toString() == null)
			str = 0;
		else
			str = Integer.parseInt(stat.getText().toString());
		stat = (EditText) v.findViewById(R.id.editDex);
		if(stat.getText().toString() == null)
			dex = 0;
		else
			dex = Integer.parseInt(stat.getText().toString());
		stat = (EditText) v.findViewById(R.id.editCon);
		if(stat.getText().toString() == null)
			con = 0;
		else
			con = Integer.parseInt(stat.getText().toString());
		stat = (EditText) v.findViewById(R.id.editInt);
		if(stat.getText().toString() == null)
			inte = 0;
		else
			inte = Integer.parseInt(stat.getText().toString());
		stat = (EditText) v.findViewById(R.id.editWis);
		if(stat.getText().toString() == null)
			wis = 0;
		else
			wis = Integer.parseInt(stat.getText().toString());
		stat = (EditText) v.findViewById(R.id.editCha);
		if(stat.getText().toString() == null)
			cha = 0;
		else
			cha = Integer.parseInt(stat.getText().toString());
				
		
		//DON'T QUESTION MY BADLY STRUNG OUT CHECK
		if(str>18||str < 3||dex>18||dex < 3||con>18||con<3||inte>18||inte<3||wis>18||wis<3||cha>18||cha<3)
		{
			//display message to inform all stats must be in range of 3 to 18
			return;
		}
		
		Intent intent = new Intent( this, New_Char_Skills.class );
		
		//intent.putExtra(/*data to deliver goes here*/ );
		startActivity(intent);
	}

}
