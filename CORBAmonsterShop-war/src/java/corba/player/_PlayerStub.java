package player;


/**
* player/_PlayerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from player.idl
* Thursday, 21 May 2015 16:32:51 o'clock KST
*/

public class _PlayerStub extends org.omg.CORBA.portable.ObjectImpl implements player.Player
{

  public player.PlayerInfo getPlayer (int phone) throws player.SQLError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getPlayer", true);
                $out.write_long (phone);
                $in = _invoke ($out);
                player.PlayerInfo $result = player.PlayerInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:player/SQLError:1.0"))
                    throw player.SQLErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getPlayer (phone        );
            } finally {
                _releaseReply ($in);
            }
  } // getPlayer

  public player.PlayerInfo deletePlayer (int phone) throws player.SQLError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("deletePlayer", true);
                $out.write_long (phone);
                $in = _invoke ($out);
                player.PlayerInfo $result = player.PlayerInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:player/SQLError:1.0"))
                    throw player.SQLErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return deletePlayer (phone        );
            } finally {
                _releaseReply ($in);
            }
  } // deletePlayer

  public player.PlayerInfo updatePlayer (String name, int phone, String password, int calory_burned_total, int steps_taken, int exp, int weight, int monster_money, String email) throws player.SQLError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updatePlayer", true);
                $out.write_wstring (name);
                $out.write_long (phone);
                $out.write_wstring (password);
                $out.write_long (calory_burned_total);
                $out.write_long (steps_taken);
                $out.write_long (exp);
                $out.write_long (weight);
                $out.write_long (monster_money);
                $out.write_wstring (email);
                $in = _invoke ($out);
                player.PlayerInfo $result = player.PlayerInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:player/SQLError:1.0"))
                    throw player.SQLErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return updatePlayer (name, phone, password, calory_burned_total, steps_taken, exp, weight, monster_money, email        );
            } finally {
                _releaseReply ($in);
            }
  } // updatePlayer

  public player.PlayerInfo createPlayer (String name, int phone, String password, int calory_burned_total, int steps_taken, int exp, int weight, int monster_money, String email)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("createPlayer", true);
                $out.write_wstring (name);
                $out.write_long (phone);
                $out.write_wstring (password);
                $out.write_long (calory_burned_total);
                $out.write_long (steps_taken);
                $out.write_long (exp);
                $out.write_long (weight);
                $out.write_long (monster_money);
                $out.write_wstring (email);
                $in = _invoke ($out);
                player.PlayerInfo $result = player.PlayerInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return createPlayer (name, phone, password, calory_burned_total, steps_taken, exp, weight, monster_money, email        );
            } finally {
                _releaseReply ($in);
            }
  } // createPlayer

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:player/Player:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _PlayerStub
