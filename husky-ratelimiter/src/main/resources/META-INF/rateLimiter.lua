-- key+1 ,获取失效时间
local key = KEYS[1]
local usedCount = redis.call('incr', key)
local ttl = redis.call('ttl', key)

-- 传入的参数，定义失效时间  最大允许次数
local expire = ARGV[1]
local times = ARGV[2]

if usedCount == 1 then
    redis.call('expire', key, tonumber(expire))
else
    if ttl == -1 then
        redis.call('expire', key, tonumber(expire))
    end
end

-- 总次数大于设置次数，返回1
if usedCount <= tonumber(times) then
    return 1
end

return {usedCount,ttl}