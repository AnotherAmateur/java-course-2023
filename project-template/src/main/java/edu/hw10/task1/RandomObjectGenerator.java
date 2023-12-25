package edu.hw10.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Random;

class RandomObjectGenerator {
    private final Random random;

    public RandomObjectGenerator() {
        this.random = new Random();
    }

    public <T> T nextObject(Class<T> tClass) throws Exception {
        Constructor<?>[] constructors = tClass.getDeclaredConstructors();

        for (var constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                constructor.setAccessible(true);
                return (T) constructor.newInstance();
            }
        }

        constructors[0].setAccessible(true);
        return generateObjByConstructor(constructors[0]);
    }

    public <T> T nextObject(Class<T> tClass, String factoryMethod) throws Exception {
        Method facMethod = tClass.getDeclaredMethod(factoryMethod);
        return (T) facMethod.invoke(null);
    }

    private <T> T generateObjByConstructor(Constructor<?> constructor) throws Exception {
        Parameter[] params = constructor.getParameters();
        Object[] args = new Object[params.length];

        for (int i = 0; i < params.length; i++) {
            Class<?> type = params[i].getType();

            if (type.isPrimitive()) {
                args[i] = generatePrimitiveObj(type, params[i].getAnnotations());
            } else {
                args[i] = generateClassObj(type, params[i].getAnnotations());
            }
        }

        return (T) constructor.newInstance(args);
    }

    private <T> T generateClassObj(Class<?> type, Annotation[] annotations) throws Exception {
        for (var annotation : annotations) {
            if (annotation instanceof NotNull) {
                return (T) nextObject(type);
            }
        }

        return null;
    }

    private Object generatePrimitiveObj(Class<?> type, Annotation[] annotations) {
        Number minValue = Double.NEGATIVE_INFINITY;
        Number maxValue = Double.MAX_VALUE;

        for (var annotation : annotations) {
            if (annotation instanceof Min) {
                minValue = ((Min) annotation).value();
            } else if (annotation instanceof Max) {
                maxValue = ((Max) annotation).value();
            }
        }

        if (type == int.class || type == Integer.class) {
            return random.nextInt(minValue.intValue(), maxValue.intValue());
        }
        if (type == double.class || type == Double.class) {
            return minValue.doubleValue() + random.nextDouble() * (maxValue.doubleValue() - minValue.doubleValue());
        }
        if (type == float.class || type == Float.class) {
            return minValue.floatValue() + random.nextFloat() * (maxValue.floatValue() - minValue.floatValue());
        }
        if (type == boolean.class || type == Boolean.class) {
            return random.nextBoolean();
        }
        if (type == long.class || type == Long.class) {
            return random.nextLong();
        }

        throw new UnsupportedOperationException();
    }
}
