package name.luoyong.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class App  {

	
	public static void main(String[] args) throws Exception {
		CacheManager cacheManager = CacheManager.create();
		Cache userCache = cacheManager.getCache("userCache");
		
		Element luoyong = new Element("luoyong", new User("罗勇"));
		
		userCache.put(luoyong);
		
		for(int i=0; i<3; i++) {
			Thread.sleep(1300);
			Element luoyongElement = userCache.get("luoyong");
			if(luoyongElement == null) {
				System.out.println("luoyongElement is not in userCache now.");
				break;
			}
			User ly = (User)luoyongElement.getObjectValue();
			System.out.println(ly.getName());
		}

	}
}

