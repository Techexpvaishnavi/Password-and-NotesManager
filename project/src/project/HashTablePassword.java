package project;

public class HashTablePassword  implements HashTableMap
{

	private final int useProbe;
	private Entry[] entries;
	private final  float loadFactor;    
	private int used, size ;       //used acquires space for NIL;
	private final Entry NIL = new Entry(null ,null);
	private static class Entry
	{
		Object key, value;
		Entry(Object k, Object v)
		{
			key=k;
			value =v;
		}
	}
	public HashTablePassword( int capacity , float loadFactor ,int useProbe) 
	{
	    entries = new Entry[ capacity] ;
		this.loadFactor = loadFactor;
		this.useProbe = useProbe;
	}
	
	
	// Complementary function
	public int hash(Object key)
	{
		return (key.hashCode() & 0x7FFFFFFF)% entries .length;
	}
	private int nextProbe(int h, int i)
	{
		return (h+i)% entries.length;   //Linear Probing
	}
	private void rehash()
	{
		Entry[] oldEntries = entries;
		entries = new Entry[2*entries.length+1];
		for(Entry entry :oldEntries) 
		{
			if(entry == NIL || entry == null)continue;
			int h = hash(entry.key);
			for (int x=0; x< entries.length; x++)
			{
				int j = nextProbe(h, x);
				if(entries[j] == null)
				{
					entries[j] = entry;
					break;
				}
			}
		
			used = size;
		}
	}
	

	@Override
	public Object get_Acc(Object Account)
	{
		int h = hash(Account);
		for (int i=0 ;i < entries.length; i++)
		{
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if(entry == null)break;
			if(entry == NIL)continue;
			if(entry.key.equals(Account)) return entry.value;
		}
		return null;
	}

	@Override
	public int add_Acc(Object Account, Object passwd) 
	{
		if(used > (loadFactor*entries.length))rehash();
		int h =  hash(Account);
		for ( int i=0;i < entries.length;i++)
		{
			int j = (h+i)% entries.length;
			Entry entry = entries[j];
			if(entry == null)
			{
				entries[j] = new Entry(Account , passwd);
				++size;
				++used;
				return h;
			}
			if(entry == NIL)continue;
			if(entry.key.equals(Account))
			{
				Object oldValue = entry.value;
				entries[j].value = passwd;
				return (int)oldValue;
			}
		}
		return h;

	}

	@Override
	public Object remove_Acc(Object Account) 
	{
		int h = hash(Account);
		for(int i= 0;i< entries.length; i++)
		{
			int j = nextProbe(h,i);
			Entry entry = entries[j];
			if(entry == NIL)continue;
			if(entry.key.equals(Account))
			{
				Object value = entry.value;
				entries[j] = NIL;
				size--;
				return value;
			}
			
		}
		return null;
	}
}
