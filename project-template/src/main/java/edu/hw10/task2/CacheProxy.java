package edu.hw10.task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CacheProxy implements InvocationHandler {
    private final Object targetClassObj;
    private final Map<String, Object> cacheMap;

    private CacheProxy(Object targetClassObj) {
        this.targetClassObj = targetClassObj;
        this.cacheMap = new HashMap<>();
    }

    public static <T> T create(Object target, Class<T> If) {
        return (T) Proxy.newProxyInstance(
            If.getClassLoader(),
            new Class<?>[] {If},
            new CacheProxy(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String key = method.getName() + Arrays.toString(args);

        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }

        Object result = method.invoke(targetClassObj, args);
        cacheMap.put(key, result);

        if (shouldPersist(method)) {
            saveResultToTmpDir(key, result);
        }

        return result;
    }

    private void saveResultToTmpDir(String key, Object result) throws IOException {
        Path tempDir = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "fib cache");
        Files.createDirectories(tempDir);
        Path filePath = tempDir.resolve(key + ".txt");

        if (!Files.exists(filePath)) {
            try (var outputStream = new ObjectOutputStream(new FileOutputStream(filePath.toFile()))) {
                outputStream.writeObject(result);
            }
        }
    }

    private static boolean shouldPersist(Method method) {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);
        return cacheAnnotation != null && cacheAnnotation.persist();
    }
}
