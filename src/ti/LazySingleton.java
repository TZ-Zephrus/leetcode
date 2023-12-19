package ti;

import java.util.concurrent.ConcurrentHashMap;

public class LazySingleton {
    private static volatile LazySingleton lazyInstance;
    private LazySingleton(){
    }
    public LazySingleton getLazyInstance() {
        if (lazyInstance == null) {
            synchronized (LazySingleton.class) {
                if (lazyInstance == null) {
                    lazyInstance = new LazySingleton();
                }
            }
        }
        return lazyInstance;
    }
}
