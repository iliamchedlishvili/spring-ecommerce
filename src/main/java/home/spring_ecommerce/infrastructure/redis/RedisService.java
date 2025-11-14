package home.spring_ecommerce.infrastructure.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

    Duration ttl = Duration.ofMinutes(20);
    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisService(StringRedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public  <T> void saveData(String key, T data) {
        try {
            String json = objectMapper.writeValueAsString(data);
            redisTemplate.opsForValue().set(key, json, ttl);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Error serializing object to JSON", ex);
        }
    }

    public <T> T getData(String key, Class<T> obj) {
        try {
            String json = redisTemplate.opsForValue().get(key);
            return objectMapper.readValue(json, obj);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Error deserializing JSON from Redis", ex);
        }
    }
}