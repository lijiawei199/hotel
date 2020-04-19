package net.fly.order.core.util;

import net.fly.order.core.sequence.Sequence;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-05 20:15
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Component
public class IdGenerateUtils {

    private static Sequence sequence;

    public static Long generateSnowId() {
        return sequence.nextId();
    }

    public static String generateSnowId(String gen) {
        return gen + sequence.nextId();
    }

    public static List<String> randomList(int length, int count, boolean letters, boolean numbers) {
        Assert.isTrue(length > 0 && count > 0, "长度和数量必须大于0");
        Set<String> set = new HashSet<>();
        while (set.size() < count) {
            set.add(RandomStringUtils.random(length, letters, numbers));
        }
        return new ArrayList<>(set);
    }

    public static List<String> randomList(int length, int count) {
        return randomList(length, count, true, true);
    }

    public static List<String> randomNumberList(int length, int count) {
        return randomList(length, count, false, true);
    }

    public IdGenerateUtils() {
    }

    @Autowired
    public IdGenerateUtils(Sequence sequence) {
        IdGenerateUtils.sequence = sequence;
    }
}
