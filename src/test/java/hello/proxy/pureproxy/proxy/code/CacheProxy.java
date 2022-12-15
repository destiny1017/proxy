package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private final Subject target;
    private String cacheData;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        if(cacheData == null) {
            cacheData = target.operation();
        } else log.info("프록시 객체 호출");
        return cacheData;
    }
}
