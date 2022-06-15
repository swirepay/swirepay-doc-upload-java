package com.swirepay;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


public class SwirepayDocUpload {

    public static final String SAMPLE_FILE = "sample.png";
    public static final String UPLOAD_URL = "https://swirepay-landing-stag.s3.ap-south-1.amazonaws.com/57e6248c-559e-464f-8df4-e5c1488e7ac7?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEJn%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCmFwLXNvdXRoLTEiRjBEAiAH97dkmk7kAWJ2NuPJQ6ASPrcPpZmqbB1ywk6KPlrbFAIgEd6jp7sIQzGYIwbUFbxBOJzRcg6Ps%2Bln98ckDApcIXYqjwQIov%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARACGgwzNTEyMDQ3MjkyMjgiDDlLYGnxUwu4TQ%2BETyrjAxiR9ZOTctvcjIaDhm38Xbp2gm4buiVmd0puRux5JTQ%2FoaEQp%2F28mIVySirRpkoKGCvQH6OFtwoBYk40M4LYPSWBgp0%2Bydh%2Bq9FYJmjj1tfglB4vx7wiUPSuil8ivajPViPjAgu%2B3I9Sv7axVPHpCIQZBN2I9uzT0k46j4r4xY6U3adKBgnVzSOeTgGuloLDhF3tePdhQ2VfJWDmiNcU%2BX9tQ3HmgkcYyPd1e36FFLf6t11290HGUkCt%2FTWs17XQQoPvhWmJFXeUimezXRWx67SZQIWLcot7z2nXfOoUXmy46C1fN%2BTltVtDs3YxGfHp1YE8j0dfK1VmhPdVtyfThnTn6nvTs4DMAJGQjAWsgbRLlo2afsgR%2BoexguudY2v%2BYc2jpvcMVLFuwLcaJfEBM9pdeI2pihXremtqD55T9DZ4T76uj8gLhFSXpOSdZEIw%2BC99FWLXs%2B6SyNEqBjsTeVossKWGsYD0wkzbRudWAEK6T79Li%2B7Ros7OGSKAOCnPgR9NgWhwXQDu0RqsUHJTp4AJYWwUIR4gTIdiAAbF%2FX1wLR4Inbu%2FA221eLVA%2BOb56h9uaWMX%2BRV3XmTpt5sq1jzNWFjf5HGbd%2BOUT0NAu9JP505I7GwYIr9ytmVAyB0vJEZwWjCmtKaVBjqmAVQzu5uH%2FBL2FnL0lbpjdeDTFwtqszuUgig2B6glg4hpgCV6lhL%2FNLWZsYNDchhgaUXQWuCZIik1Ya%2FHMUETjWAdGykyO38wv69IL1Rkd8yEdcQbOZGFmz81gLbm13I9I4xYUeIW0EyTrkxeBWUfUClQAnPR0IT3dFGm4LLiRDtvXBCFvp572iqP1K2LuiGEX3Fk6nI3dkfWBjVgFBp1x8AtnZnkJa8%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20220615T095602Z&X-Amz-SignedHeaders=host&X-Amz-Expires=1799&X-Amz-Credential=ASIAVDRLO4GGGJ2N25GO%2F20220615%2Fap-south-1%2Fs3%2Faws4_request&X-Amz-Signature=d289ed1451c8ff341e0a1fbbaf38938de6f7beac62fc87492063a768206742ae";

    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("file", new FileSystemResource(SAMPLE_FILE));

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.exchange(new URI(UPLOAD_URL), HttpMethod.PUT, request, String.class);
        System.out.printf("Status code :%s%n", response.getStatusCodeValue());
    }
}
