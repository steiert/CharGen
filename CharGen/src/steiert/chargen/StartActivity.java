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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class StartActivity extends Activity {

	private GameResources data; //will be static data
/*
	private Button viewchar;
	private Button newchar;
	private Button delchar;
*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		GameResources.load();//loads game data
/*		
		viewchar = (Button) findViewById(R.id.viewchar);
		newchar = (Button) findViewById(R.id.newchar);
		delchar = (Button) findViewById(R.id.deletechar);
		
		viewchar.setOnClickListener(this);
		newchar.setOnClickListener(this);
		delchar.setOnClickListener(this);
*/		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}
	
	public void loadCharacter(View v) {
		List<String> characters = find_characters();
		String name;
		/*
		try{//display message with list and let selection
			name =null;//set name
		}catch(){
			//if fail to get
			return;
		}
		data.player.load(name);
		 * 
		 */
		//start view_char, pass it player
	}
	
	public void createCharacter(View v) {
		Intent intent = new Intent(this, NewChar.class);
		startActivity(intent);
	}	
	
	public void deleteCharacter(View v) {
		List<String> characters = find_characters();
		String name;	
		/*
		try{//display message with list and let selection
			name =;//set name
		}catch(){
			//if fail to get
			return;
		}
		*/
		//delete the character
	}

	private List<String> find_characters() {
		return null;
	}

}
