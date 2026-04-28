package com.example.agent;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final String GEMINI_API_KEY = "YOUR_GEMINI_API_KEY";

    @GetMapping("/chat")
    public String chat(@RequestParam String query) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            // Get products from product-service
            List<Map<String, Object>> products =
                    restTemplate.getForObject(
                            "http://product-service:8081/products",
                            List.class
                    );

            // Build prompt
            String prompt = "User query: " + query +
                    "\nAvailable products: " + products +
                    "\nSuggest best matching product.";

            // Gemini API URL
            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + GEMINI_API_KEY;

            // Request body
            Map<String, Object> body = new HashMap<>();
            List<Map<String, Object>> contents = new ArrayList<>();

            Map<String, Object> content = new HashMap<>();
            List<Map<String, String>> parts = new ArrayList<>();

            Map<String, String> part = new HashMap<>();
            part.put("text", prompt);

            parts.add(part);
            content.put("parts", parts);
            contents.add(content);

            body.put("contents", contents);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(body, headers);

            Map response = restTemplate.postForObject(url, request, Map.class);

            // Extract response text
            List candidates = (List) response.get("candidates");
            Map first = (Map) candidates.get(0);
            Map contentMap = (Map) first.get("content");
            List partsList = (List) contentMap.get("parts");
            Map textPart = (Map) partsList.get(0);

            return textPart.get("text").toString();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}