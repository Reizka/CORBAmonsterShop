package monster;


/**
* monster/_MonsterStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from monster.idl
* Thursday, 21 May 2015 16:44:47 o'clock KST
*/

public class _MonsterStub extends org.omg.CORBA.portable.ObjectImpl implements monster.Monster
{

  public monster.MonsterInfo getAllMonster ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getAllMonster", true);
                $in = _invoke ($out);
                monster.MonsterInfo $result = monster.MonsterInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getAllMonster (        );
            } finally {
                _releaseReply ($in);
            }
  } // getAllMonster

  public monster.MonsterInfo getMonster (int id) throws monster.SQLError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getMonster", true);
                $out.write_long (id);
                $in = _invoke ($out);
                monster.MonsterInfo $result = monster.MonsterInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:monster/SQLError:1.0"))
                    throw monster.SQLErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getMonster (id        );
            } finally {
                _releaseReply ($in);
            }
  } // getMonster

  public monster.MonsterInfo deleteMonster (int id) throws monster.SQLError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("deleteMonster", true);
                $out.write_long (id);
                $in = _invoke ($out);
                monster.MonsterInfo $result = monster.MonsterInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:monster/SQLError:1.0"))
                    throw monster.SQLErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return deleteMonster (id        );
            } finally {
                _releaseReply ($in);
            }
  } // deleteMonster

  public monster.MonsterInfo updateMonster (String name, int id, boolean owned, String img, int value, int player_id) throws monster.SQLError
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateMonster", true);
                $out.write_wstring (name);
                $out.write_long (id);
                $out.write_boolean (owned);
                $out.write_wstring (img);
                $out.write_long (value);
                $out.write_long (player_id);
                $in = _invoke ($out);
                monster.MonsterInfo $result = monster.MonsterInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:monster/SQLError:1.0"))
                    throw monster.SQLErrorHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return updateMonster (name, id, owned, img, value, player_id        );
            } finally {
                _releaseReply ($in);
            }
  } // updateMonster

  public monster.MonsterInfo createMonster (String name, int id, boolean owned, String img, int value, int player_id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("createMonster", true);
                $out.write_wstring (name);
                $out.write_long (id);
                $out.write_boolean (owned);
                $out.write_wstring (img);
                $out.write_long (value);
                $out.write_long (player_id);
                $in = _invoke ($out);
                monster.MonsterInfo $result = monster.MonsterInfoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return createMonster (name, id, owned, img, value, player_id        );
            } finally {
                _releaseReply ($in);
            }
  } // createMonster

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:monster/Monster:1.0"};

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
} // class _MonsterStub
