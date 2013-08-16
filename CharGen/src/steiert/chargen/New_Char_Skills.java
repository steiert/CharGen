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

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class New_Char_Skills extends Activity {

	private GameResources data;
	private SkillsAdapter m_adapter;
	private ListView listV;
	
	private int pointsleft;
	private int maxpoints;
	private int maxccpoints;
	
	//amount of points to increment 1 if cc skill
	private int ccincrement;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_char_skills);
		ccincrement = 2;
		
		pointsleft = data.player.get_stat("int").getMod() + data.newClass.skillgain;
		if(data.player.race.name == "human")
			pointsleft++;
		
		
		listV = (ListView) findViewById(R.id.listViewNewSkills);
		//m_adapter = new SkillsAdapter(this., 0 ,data.skills );
		listV.setAdapter(m_adapter);
	}
	
	private class SkillsAdapter extends ArrayAdapter<Var>{
		private Context context;
		private int resLayoutId;
		private List<Var> skills;
		
		
		public SkillsAdapter( Context context, int resLayoutId, List<Var> skills){
			Super( context, resLayoutId, skills );
			this.skills = skills;
			this.context = context;
			this.resLayoutId = resLayoutId;
		}
		
		@Override
		public View getView( int position, View convertView, ViewGroup parent){
			View v = convertView;
			if(v == null)
			{
				LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.up_skill, null);
			}
			
			Var skill = skills.get(position);
			if( skill != null)
			{
				TextView name = (TextView) v.findViewById(R.id.newskillname);
				if( name != null)
					name.setText(skill.name);
				TextView value = (TextView) v.findViewById(R.id.skillpresentvalue);
				if( value != null)
					value.setText(((Integer)skill.base).toString());
			}
			
			return v;
		}
		
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		//m_adapter = new SkillsAdapter(this, data.skills);
		listV.setAdapter(m_adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_char_skills, menu);
		return true;
	}

}
