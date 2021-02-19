package com.gupaoedu.config;

import com.google.common.collect.Range;
import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 范围查询所使用的分片算法
 */
public class TblRangeShardAlgo implements RangeShardingAlgorithm<Long> {
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> rangeShardingValue) {
        System.out.println("范围-*-*-*-*-*-*-*-*-*-*-*---------------"+availableTargetNames);
        System.out.println("范围-*-*-*-*-*-*-*-*-*-*-*---------------"+rangeShardingValue);
        Collection<String> collect = new LinkedHashSet<>();
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        for (Long i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            // 不分表
            for (String each : availableTargetNames) {
                collect.add(each);
/*                if (each.endsWith(i % availableTargetNames.size() + "")) {
                    collect.add(each);
                }*/
            }
        }
        return collect;
    }

}