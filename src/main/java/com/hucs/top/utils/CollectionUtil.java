package com.hucs.top.utils;

import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: huchuansai
 * @Date: 2022/3/29 3:08 下午
 * @Description:
 */
public class CollectionUtil extends org.springframework.util.CollectionUtils {

    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isNotEmpty(@Nullable Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
        return !isEmpty(map);
    }

    // 校验集合A是否包含集合B
    public static <T> boolean checkAContainsB(List<T> A, List<T> B) {
        if (Objects.isNull(A) || Objects.isNull(B)) {
            throw new NullPointerException();
        }

        boolean result = true;
        for (T objectB : B) {
            if (!A.contains(objectB)) {
                result = false;
                break;
            }
        }
        return result;
    }

    // 校验传入的n个集合是否都为空
    public static boolean isAllEmpty(@Nullable Collection<?>... collectionList) {
        assert collectionList != null;
        boolean isAllEmpty = true;
        for (Collection<?> collection : collectionList) {
            if (isNotEmpty(collection)) {
                isAllEmpty = false;
                break;
            }
        }
        return isAllEmpty;
    }

    // 校验传入的n个集合是否都为非空
    public static boolean isAllNotEmpty(@Nullable Collection<?>... collectionList) {
        assert collectionList != null;
        boolean isAllNotEmpty = true;
        for (Collection<?> collection : collectionList) {
            if (isEmpty(collection)) {
                isAllNotEmpty = false;
                break;
            }
        }
        return isAllNotEmpty;
    }

    // 校验传入的n个集合是否包含非空的
    public static boolean containsEmpty(@Nullable Collection<?>... collectionList) {
        assert collectionList != null;
        boolean containsEmpty = false;
        for (Collection<?> collection : collectionList) {
            if (isEmpty(collection)) {
                containsEmpty = true;
                break;
            }
        }
        return containsEmpty;
    }
}
