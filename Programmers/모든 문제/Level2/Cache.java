import java.util.ArrayList;

class Cache {
    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int runtime = 0;
        ArrayList<String> cache = new ArrayList<String>();
        
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();

            if (cache.contains(cities[i])) {
                runtime += 1;
                cache.remove(cities[i]);
                cache.add(cities[i]);
            } else {
                runtime += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                    cache.add(cities[i]);
                }
                else 
                    cache.add(cities[i]);
            }
        }
        return runtime;
    }
}