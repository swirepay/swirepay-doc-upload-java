package com.swirepay.fileupload;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/upload")
public class FileUpload {

    public static final String SAMPLE_PNG = "sample.png";
    public static final String PRE_SIGNED_URL = "https://swirepay-landing-stag.s3.ap-south-1.amazonaws.com/a91c279f-febe-4892-8ee9-5a123e0fb0d3?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEJb%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCmFwLXNvdXRoLTEiRzBFAiAuFt9tI3oe%2FUOUwAcCpdt7zidmRR5575tt4I%2BX1cukQwIhANO2y%2FhEvPtnize1Zba6Bcs13LFcTpKvvbxhpm1Wr%2BpwKo8ECJ%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEQAhoMMzUxMjA0NzI5MjI4IgzQhsvTCg%2FicCoCny0q4wMwEzqEy2fuPKDsnAFUT%2FRDjSoG7Nqrkd7voEcyElXEwEDd5E69TULBoJDhfNuYitp2XleqX0selEOeFbPYr8qXAwgQpbBGYGvlK3vUIx8lA2y%2F1vs9IpxhrgALRBMSi20cS6YFIT3RNLUzD1B8GTxdEePph0IRl85DaDcQMVuSXmnzYZWFoaHwTlwFKsMwJGC566xQIp7Le%2FyN6gY0AztQzdxrwzO6RlQfbEugVN2e%2BndHKxyuds1L27xkWk3AZwslx%2FN%2B8hRbUWl%2F8NH5EAOxVTU52ZWmZ%2Fw7aDpyGRNc4Jr8O9Jtg2ZbAqw6DsBtZLgcLQGM8qbjfBI4QL6xfqlEx5wjAJDhcjCzLgvTWZ1kDHgHq0h%2FtYtyR2dsuUxzDIgmymQXymR9%2FPUsLYCDfbRxrUQ3BCezARWA85ybse9HIOMPG9rLaJNGvxG%2FoO85o6uT13fsBUKoRcdmuZZxz2hka3yR4Sujv5%2FnJ%2FCzq8HSgf8RzDSKHpb0pIKjNk8RANlNmoHGO%2BpCQaFu%2Bx7rJScfPhNTKLAygox%2FAfk6Z7OTtbF%2FR8QLsjxn0UL13%2F%2FLPIV0hoFgFjMxj4bPbOcXRbHp1nqlS4Q5%2BIQHhMT8XO1yEPq%2BgiGzsIYcYJZS5FscEE3LImMwz%2BGllQY6pQFTRMKWtBjDrFLY0VbdFbiko2uZawojg5nFynll16fa7ka4V5mM1g0mkWGyNtclfHFlw1W0bI5wNRLUJMLBVGg55qN5utj1rcNWpwUKZAgeBqWoEfZSil9B5JYFSLOdKZPOeRatN5rjaQSUke5zP2xZ%2BSolBmnVpF4jIX2Yun%2F%2BDVNl73q%2BHYEl1w3mioM9wFLhOYQouPJAKrVOXMfl2xkvNE7GhKc%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20220615T074625Z&X-Amz-SignedHeaders=host&X-Amz-Expires=1800&X-Amz-Credential=ASIAVDRLO4GGOIOZPQ76%2F20220615%2Fap-south-1%2Fs3%2Faws4_request&X-Amz-Signature=7fd3a98c441f5ea6429d1847f24c0373a892dc8cc210d08a43a43f639fcaa234";

    @GetMapping
    public String uploadFile() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        map.add("file", new FileSystemResource(SAMPLE_PNG));

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.exchange(new URI(PRE_SIGNED_URL), HttpMethod.PUT, request , String.class);
        System.out.println(response.getBody());
        return response.getBody();
    }
}
