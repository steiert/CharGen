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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GameResources {
	
	//just for the purpose of loading once, since it's general, STATIC(global)
	public static Basic lvls;
	public static List<CharClass> classes;
	public static List<PrestClass> prstgclsses;
	public static List<Var> skills;
	public static List<Ability> feats;
	public static List<Race> races;
	
	public static PlayerChar player;
	
	public boolean insert_bonus(Bonus bns, String source){
		switch(bns.place){
		case 0://feats/class_features
			return ability_insert_bonus( bns, source );
		case 1://skill bonus
			return skill_bonus_insert( bns, source );
		case 2://casting/psionics bonus
			return special_bonus_insert( bns, source );
		case 3://stat boost
			return stat_bonus_insert( bns, source );
		case 4://classes, i.e. what
			return false;
		case 5://various bonuses
			return defence_bonus_insert(bns, source);
		case 6://save bonus
			return save_bonus_insert( bns, source );
		case 7://offensive bonuses
			return offence_bonus_insert(bns, source);
		default:
			return false;
		}
	}
	
	//just in case
	public boolean ability_insert_bonus( Bonus bns, String name ){
		for(int i=0;i<player.abils.size();i++)
		{
			Ability tmp = player.abils.get(i);
			if( tmp.name.equals(bns.name) )
			{
				Bonus newelm = new Bonus(bns, name);
				if(tmp.add == null)
					tmp.add = new ArrayList<Bonus>();
				
				tmp.add.add( newelm );
				return true;
			}
		}
		
		return false;
	}
	
	public boolean skill_bonus_insert( Bonus bns, String name ){
		for(int i=0;i<player.skills.size();i++)
		{
			Var tmp = player.skills.get(i);
			if( tmp.name.equals(bns.name) )
			{
				Bonus newelm = new Bonus(bns, name);
				if(tmp.add == null)
					tmp.add = new ArrayList<Bonus>();
				
				tmp.add.add( newelm );
				return true;
			}
		}
		
		return false;
	}
	
	public boolean defence_bonus_insert( Bonus bns, String name ){
		for(int i=0;i<player.defences.size();i++)
		{
			Var tmp = player.defences.get(i);
			if( tmp.name.equals(bns.name) )
			{
				Bonus newelm = new Bonus(bns, name);
				if(tmp.add == null)
					tmp.add = new ArrayList<Bonus>();
				
				tmp.add.add( newelm );
				return true;
			}
		}
		
		return false;
	}
	
	public boolean offence_bonus_insert( Bonus bns, String name ){
		for(int i=0;i<player.offences.size();i++)
		{
			Var tmp = player.offences.get(i);
			if( tmp.name.equals(bns.name) )
			{
				Bonus newelm = new Bonus(bns, name);
				if(tmp.add == null)
					tmp.add = new ArrayList<Bonus>();
				
				tmp.add.add( newelm );
				return true;
			}
		}
		
		return false;
	}
	
	public boolean stat_bonus_insert( Bonus bns, String name ){
		for(int i=0;i<player.stats.size();i++)
		{
			Stat tmp = player.stats.get(i);
			if( tmp.name.equals(bns.name) )
			{
				Bonus newelm = new Bonus(bns, name);
				if(tmp.add == null)
					tmp.add = new ArrayList<Bonus>();
				
				tmp.add.add( newelm );
				return true;
			}
		}
		
		return false;
	}
	
	public boolean save_bonus_insert( Bonus bns, String name ){
		for(int i=0;i<player.saves.size();i++)
		{
			Var tmp = player.saves.get(i);
			if( tmp.name.equals(bns.name) )
			{
				Bonus newelm = new Bonus(bns, name);
				if(tmp.add == null)
					tmp.add = new ArrayList<Bonus>();
				
				tmp.add.add( newelm );
				return true;
			}
		}
		
		return false;
	}
	
	//secondary priority
	public boolean special_bonus_insert( Bonus bns, String name){
		return false;
	}
	
	public boolean has_preq( List<Prequisite> preqs){
		Prequisite tmp = null;
		boolean qualifies = false;
		for(int i=0; i<preqs.size() ; i++)
		{
			qualifies = false;
			tmp = preqs.get(i);
			switch(tmp.type){
				case 0://check for feats/class_features
					qualifies = has_ability( tmp );
					break;
				case 1://check for skill rank
					qualifies = has_skill_rank( tmp );
					break;
				case 2://check for casting/psionics
					qualifies = has_special( tmp );
					break;
				case 3://check for stats i.e. strength
					qualifies = has_stat( tmp );
					break;
				case 4://check for classes
					qualifies = has_class( tmp );
					break;
				case 5://check if base attack is high enough
					qualifies = tmp.quant >= player.baseattack;
					break;
				case 6://check for base save
					qualifies = has_save( tmp );
					break;
				case 7:
					qualifies = has_align(tmp);
					break;
				default:
			}
			if( !qualifies )
				return false;
		}

		return true;
	}
	
	public boolean has_align( Prequisite preq){

		if( player.align.contains( preq.name) )
			return true;
		
		return false;
	}
	
	public boolean has_save( Prequisite preq ){
		for( int i=0; i<player.saves.size();i++)
		{
			Var tmp =player.saves.get(i);
			if(tmp.name.equals(preq.name))
				if(tmp.base>=preq.quant)
					return true;
		}
		return false;
	}
	
	public boolean has_class( Prequisite preq ){
		int total = 0;
		for( int i=0;i<player.classes.size();i++)
		{
			if( player.classes.get(i).equals(preq.name) )
				total++;
		}
		
		if( preq.quant <= total )
			return true;
		else
			return false;
	}
	
	public boolean has_stat( Prequisite preq ){
		Stat tmp = player.get_stat( preq.name );
		if( tmp.non_volatile_total() >= preq.quant)
			return true;
		else
			return false;
	}
	
	public boolean has_ability( Prequisite preq ){
		for(int i=0;i<player.abils.size();i++)
		{
			if( player.abils.get(i).name.equals(preq.name) )
				return true;
		}
		return false;
	}
	
	//lowest priority, also most 'special'(i.e. non-regular)
	public  boolean has_special( Prequisite preq ){
		return false;
	}
	
	public boolean has_skill_rank( Prequisite preq ){
		Var tmp;
		for(int i=0; i<player.skills.size();i++)
		{
			tmp =  player.skills.get(i);
			if( tmp.name.equals(preq.name) )
			{
				if( tmp.base >= preq.quant )
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	public List<PrestClass> prestige_avail(){

		List<PrestClass> prestclasses = new ArrayList<PrestClass>();
		
		for(int i=0; i< prstgclsses.size() ; i++ )
		{
			if( has_preq( prstgclsses.get(i).preq) )
				prestclasses.add( prstgclsses.get(i) ); 
		}
		return prestclasses;

	}
	
	public List<Ability> feats_avail(){
		List<Ability> availfeats = new ArrayList<Ability>();
		for(int i=0; i< feats.size() ; i++ )
		{
			if( has_preq( feats.get(i).prequisites ) )
				availfeats.add( feats.get(i) ); 
		}
		return availfeats;
	}
	
	//returns -1 if not found
	public int get_prechoice( String ref){
		for(int i=0;i<player.abils.size(); i++)
		{
			Ability tmp = player.abils.get(i);
			if( tmp instanceof AbilChoice )
			{
				if( ((AbilChoice)tmp).ident.equals(ref) )
					return ((AbilChoice)tmp).choice;
			}
		}
		return -1;
	}
	
	//temp new data
	public static CharClass newClass;
	
	//may alter to 
	public static void load(){
		//check if loaded, exit if is
		//go through files and load shit
		//File path = getExternalFilesDir(null);
		
		
	}
}
