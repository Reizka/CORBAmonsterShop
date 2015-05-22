package monster;


/**
* monster/MonsterOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from monster.idl
* Thursday, 21 May 2015 16:44:47 o'clock KST
*/

public interface MonsterOperations 
{
  monster.MonsterInfo getAllMonster ();
  monster.MonsterInfo getMonster (int id) throws monster.SQLError;
  monster.MonsterInfo deleteMonster (int id) throws monster.SQLError;
  monster.MonsterInfo updateMonster (String name, int id, boolean owned, String img, int value, int player_id) throws monster.SQLError;
  monster.MonsterInfo createMonster (String name, int id, boolean owned, String img, int value, int player_id);
} // interface MonsterOperations