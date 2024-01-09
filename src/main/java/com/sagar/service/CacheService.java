package com.sagar.service;

import com.sagar.constants.EvictionPolicy;
import com.sagar.dao.CacheDao;
import com.sagar.model.Cache;

public class CacheService {

    private static volatile CacheService instance=null;
    private CacheService(){

    }

    //singleton -- lazy intialization // not thread safe
    //double check locking pattern
    public static CacheService getInstance(){

        if(instance ==null){
            synchronized (CacheService.class){
                if(instance==null)
                    instance=new CacheService();

            }

        }
        return instance;
    }

    private CacheDao cacheDao= CacheDao.getInstance();

    public Cache init(int size, EvictionPolicy evictionPolicy){
        return cacheDao.createCache(size,evictionPolicy);
    }
    public Object get(Object obj){
        return cacheDao.get(obj);
    }
    public Boolean put(Object key, Object val){
        return cacheDao.put( key, val);
    }
    public Boolean delete(Object key){
        return  cacheDao.delete( key);
    }
    public Boolean clear(){
        return cacheDao.clear();
    }
}
