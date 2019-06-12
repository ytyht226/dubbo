package org.apache.dubbo.cache;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class CacheFactory$Adaptive implements CacheFactory {
    public Cache getCache(org.apache.dubbo.common.URL arg0, org.apache.dubbo.rpc.Invocation arg1) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg0;
        if (arg1 == null) throw new IllegalArgumentException("invocation == null");
        String methodName = arg1.getMethodName();
        String extName = url.getMethodParameter(methodName, "cache", "lru");
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.cache.CacheFactory) name from url (" + url.toString() + ") use keys([cache])");
        CacheFactory extension = (CacheFactory) ExtensionLoader.getExtensionLoader(CacheFactory.class).getExtension(extName);
        return extension.getCache(arg0, arg1);
    }
}