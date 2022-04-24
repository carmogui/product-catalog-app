package com.personal.productcatalog.utils;

import java.util.Iterator;
import java.util.function.BiConsumer;

public class ActionUtils {

    public static  <T> void updateToChainOfResponsibility(Iterator<T> iterator, BiConsumer<T, T> consumer) {
        if(iterator != null && iterator.hasNext()) {
            T current = iterator.next();

            while(iterator.hasNext()) {
                T next = iterator.next();
                consumer.accept(current, next);
                current = next;
            }
        }
    }
}
